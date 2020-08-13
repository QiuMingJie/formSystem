--函数声明头部，函数和存储过程其实理论上来说是一致的，差别不是很大，都是有入参然后进行一些事情然后回参
--不过函数可能更加多的是有运算，而存储过程比较多返回一个游标（一个sql返回的结果）
--这里是创建或者代替函数叫 GET_DUEDATE1 ， 入参一个 ，date类型，叫 DISCHARGEON ，返回一个date类型的东西
create or replace FUNCTION "GET_DUEDATE1"(DISCHARGEON in date) return date
    IS
    --变量声明，声明了三个变量，其中dueDate是date类型，是用来存最后的结果的，所以没有给初始值
    dueDate date;
    --这两个也是变量，int类型，就是数字类型，给了初始值 :=这个符号是oracle固有的，就是 等于啦，就是赋值
    iID     int := 1;
    iDays   int := 0;
begin
    --这里要注意，一种很常见的语法 ，比如我 select 1 into iID from dual ，假如我直接select 1 from dual 返回结果就是1嘛
    --然后我into iID，就是等于把这个iID赋值到1，所以我那一句就是等于说 iID :=1 ，不过为什么还要写一个select那么麻烦，
    --就是有时候我们要调用oracle的函数，比如说字符串切割，或者时间转换

    --这个trunc是进行尾部取整的函数，具体你可以百度看一下用法就知道了，然后这里是对一个时间进行截取
    --我们时间一般来说哈，是yyyy-MM-dd HH:mm:ss 这样子的格式，这里有很多讲究也有很多种写法，y对应year，m对应mouth这样子
    --不过时间你要注意，因为mouth刚刚好和分钟的英文首字母一样都是m，所以我们约定就是月份的m是大写的M，小写的是分钟
    --他这里的函数，就是等于把传进来的，取得日期，其实是取得day，就是几号，2020-09-31 (yyyy-MM-dd) ,这样子匹配dd就是31了
    --然后取得号之后赋值给dueDate
    select trunc(DISCHARGEON, 'DD') + 0 into dueDate from dual;
    --这里是循环，假如iID小于4，就一直循环loop 到end loop里面的东西直到iID不小于4，所以一开始iID是1，绝对会进去
    while iID < 4
        loop
            select trunc(dueDate, 'DD') + 1 into dueDate from dual;
            --这里，对于日期 to_char() ，转成字符串，不过！后面多了第二个参数，就是'D'，这样子的话，是吧号转成数字
            --就是说2020年8月10日这样子，假如我直接拿到日，就是10号，这不是我要的，我要知道它是星期几，所以就tochar第二个
            --参数加D，这样子返回就是 2 ，2代表是星期一，1-7 表示星期日到星期六，外国人认为星期日是一个星期的第一天哈
            --这里进行了判断，假如是星期六日一种算法，其他星期一到五另外一种算法，用if elseIf这样子分开
            if to_char(dueDate, 'D') in ('1', '7') THEN --如果是周六日，但属于节假日加班，则算工作日
                --呐呐呐，这里又是select ? into ? ，就是给iDays赋值
                SELECT count(1)
                into iDays
                --这个form的结果很复杂，用了正则这里的话可能得我教你会正则之后你看起来好一点，看起来是从一个表拿name=WorkingDsys
                --然后进行匹配切割
                FROM (select regexp_substr(value, '[^,]+', 1, rownum) WorkingDays
                      from (select value from CORE.ParameterValue where name = 'WorkingDays')
                      --这里的connect by是递归，这个很高级，就约等于循环select吧
                      connect by rownum <= length(value) - length(replace(value, ',', '')) + 1)
                WHERE WorkingDays = dueDate;

                iID := iID + iDays;
            elsif to_char(dueDate, 'D') not in ('1', '7') then --如果不是周六日，但属于节假日，则算休息日。
                SELECT (case count(*) when 1 then 0 else 1 end)
                into iDays
                FROM (select regexp_substr(value, '[^,]+', 1, rownum) WorkingDays
                      from (select value from CORE.ParameterValue where name = 'NonWorkDays')
                      connect by rownum <= length(value) - length(replace(value, ',', '')) + 1)
                WHERE WorkingDays = '2020/04/28';
                iID := iID + iDays;
            end if;
        end loop;

    return dueDate;
end;
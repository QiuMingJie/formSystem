--初始化sql语句
IF OBJECT_ID('V_OPS_QUEUE') IS NULL
BEGIN
    create view  V_OPS_QUEUE as  select b.room_name, a.* from OPS_Queue a ,Operation_Room_Info b where a.operation_room=b.room_no;
END
ELSE
    alter view  V_OPS_QUEUE as  select b.room_name, a.* from OPS_Queue a ,Operation_Room_Info b where a.operation_room=b.room_no;
BEGIN
END
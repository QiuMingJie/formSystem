package com.qiumingjie.inter;

import java.io.Serializable;

public interface GetId<K extends Serializable, T>{
	K getId(T t);
}

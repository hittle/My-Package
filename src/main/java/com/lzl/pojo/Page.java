package com.lzl.pojo;

import java.security.KeyStore.PrivateKeyEntry;

import com.mysql.cj.protocol.a.NativeConstants.IntegerDataType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Page {

	private Integer index;
	private Integer pageNum;
}

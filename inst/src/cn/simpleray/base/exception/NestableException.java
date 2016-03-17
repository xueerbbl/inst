package cn.simpleray.base.exception;
/**
 * Copyright (c) 2000-2014 Alan Zhang. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */


public class NestableException extends Exception {
	public NestableException() {
		super();
	}

	public NestableException(String msg) {
		super(msg);
	}

	public NestableException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public NestableException(Throwable cause) {
		super(cause);
	}
}

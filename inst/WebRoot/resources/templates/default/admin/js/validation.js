//---------------------------------------------------------------------------------------------------
//为上面提供各个JS验证方法提供.trim()属性
String.prototype.trim = function() {
	return this.replace(/(^\s*)|(\s*$)/g, "");
}

//返回是否可以提交True/False
function getValidati(asHidValidation) {
		//隐藏控件
		var vHid = document.getElementsByName(asHidValidation);

		for (var i = 0; i < vHid.length; i++) {
			//有验证没通过得
			if (vHid[i].value == "1") {
				return false;
			}
		}
		//正确
		return true;
	}
	//-----------------------------------------------------


//根据类型调用不通JS
//-----------------------------------------------------
//asType: 验证类型
function validati(asType, asTestId) {
	var asHidValidation = "hid_" + asTestId;
	var asDivId = "msg_" + asTestId;

	validatiText(asType, asHidValidation, asTestId, asDivId);
}

function validatiText(asType, asHidValidation, asTestId, asDivId) {
		//id
		if (asType == "id") {
			getId(asHidValidation, asTestId, asDivId);
			return;
		}

		//name
		if (asType == "name") {
			getName(asHidValidation, asTestId, asDivId);
			return;
		}

		//cen内容
		if (asType == "cen") {
			getCen(asHidValidation, asTestId, asDivId);
			return;
		}

		//note备注
		if (asType == "note") {
			getNote(asHidValidation, asTestId, asDivId);
			return;
		}

		//用户名重复
		if (asType == "usernameRe") {
			getUsernameRe(asHidValidation, asTestId, asDivId);
			return;
		}

		//密码
		if (asType == "pass") {
			getPass(asHidValidation, asTestId, asDivId);
			return;
		}

		//确认密码
		if (asType == "RePass") {
			getRePass(asHidValidation, asTestId, asDivId);
			return;
		}

		//时间
		if (asType == "time") {
			getTime(asHidValidation, asTestId, asDivId);
			return;
		}

		//时间 不用比较开始结束日期
		if (asType == "timeNoBeginToEnd") {
			getTimeNoBeginToEnd(asHidValidation, asTestId, asDivId);
			return;
		}

		//电话
		if (asType == "tel") {
			getTel(asHidValidation, asTestId, asDivId);
			return;
		}
		//need time
		if (asType == "howtime") {
			getHowtime(asHidValidation, asTestId, asDivId);
			return;
		}

		//e-mail
		if (asType == "e-mail") {
			getMail(asHidValidation, asTestId, asDivId);
			return;
		}

		//地址
		if (asType == "add") {
			getAdd(asHidValidation, asTestId, asDivId);
			return;
		}
		///////////////////////////////////////////////////////////
		///////////////////////////////////////////////////////////
		//文本长度
		if (asType == "text") {
			getText(asHidValidation, asTestId, asDivId);
			return;
		}
		//下拉选
		if (asType == "selected") {
			getSelect(asHidValidation, asTestId, asDivId);
			return;
		}
		//时间
		if (asType == "isTime") {
			getIsTime(asHidValidation, asTestId, asDivId);
			return;
		}
	}
	//-----------------------------------------------------

//每个类型判断
//-----------------------------------------------------
//text,id验证
function getId(asHidValidation, asText, asDiv) {
	//Text控件
	var vText = document.getElementById(asText);
	var strText = vText.value.trim();

	//空判断
	if (IsNull(strText) == false) {
		setDivError(asHidValidation, asText, asDiv, "NULL");
		return false;
	}

	//其他判断

	setDivReight(asHidValidation, asText, asDiv);
	return true;

}

//text,用户名重复验证
function getUsernameRe(asHidValidation, asText, asDiv) {
	//Text控件
	var vText = document.getElementById(asText);
	var strText = vText.value.trim();
	var vHidValidation = document.getElementById(asHidValidation).value;

	//空判断
	if (IsNull(strText) == false) {
		setDivError(asHidValidation, asText, asDiv, "NULL");
		return false;
	}

	//用户名重复
	if (vHidValidation == '1') {

		setDivError(asHidValidation, asText, asDiv, "RE");

		return false;
	}

	setDivReight(asHidValidation, asText, asDiv);
	return true;

}

//text,name验证
function getName(asHidValidation, asText, asDiv) {
	//Text控件
	var vText = document.getElementById(asText);
	var strText = vText.value.trim();

	//空判断
	if (IsNull(strText) == false) {
		setDivError(asHidValidation, asText, asDiv, "NULL");
		return false;
	}

	//最大长度
	if (MaxValue(strText, '10') == false) {
		setDivError(asHidValidation, asText, asDiv, "MAXIMUM");
		return false;
	}

	setDivReight(asHidValidation, asText, asDiv);
	return true;

}

//text,内容验证
function getCen(asHidValidation, asText, asDiv) {
	//Text控件
	var vText = document.getElementById(asText);
	var strText = vText.value.trim();

	//空判断
	if (IsNull(strText) == false) {
		setDivError(asHidValidation, asText, asDiv, "NULL");
		return false;
	}

	//最大长度
	if (MaxValue(strText, '30') == false) {
		setDivError(asHidValidation, asText, asDiv, "MAXIMUM");
		return false;
	}

	setDivReight(asHidValidation, asText, asDiv);
	return true;

}

//text,内容验证
function getNote(asHidValidation, asText, asDiv) {
	//Text控件
	var vText = document.getElementById(asText);
	var strText = vText.value.trim();

	//空判断
	if (IsNull(strText) == false) {
		setDivError(asHidValidation, asText, asDiv, "NULL");
		return false;
	}

	//最大长度
	if (MaxValue(strText, '400') == false) {
		setDivError(asHidValidation, asText, asDiv, "MAXIMUM");
		return false;
	}

	setDivReight(asHidValidation, asText, asDiv);
	return true;

}

//text,pass验证
function getPass(asHidValidation, asText, asDiv) {
	//Text控件
	var vText = document.getElementById(asText);
	var strText = vText.value.trim();

	//空判断
	if (IsNull(strText) == false) {
		setDivError(asHidValidation, asText, asDiv, "NULL");
		return false;
	}

	//判断输入的字符是否为:a-z,A-Z,0-9
	if (IsString(strText) == false) {
		setDivError(asHidValidation, asText, asDiv, "STRING");
		return false;
	}

	setDivReight(asHidValidation, asText, asDiv);
	return true;

}

//text,pass2验证
function getRePass(asHidValidation, asText, asDiv) {
	//Text控件
	var vText1 = document.getElementById('txtUser_pass');
	var vText2 = document.getElementById('txtUser_pass2');
	var strText1 = vText1.value.trim();
	var strText2 = vText2.value.trim();

	//空判断
	if (IsNull(strText2) == false) {
		setDivError(asHidValidation, asText, asDiv, "NULL");
		return false;
	}

	//俩个密码不相同
	if (strText1 != strText2) {
		setDivError(asHidValidation, asText, asDiv, "PASSDISPARITY");
		return false;
	}

	setDivReight(asHidValidation, asText, asDiv);
	return true;

}

//text,时间验证
function getTime(asHidValidation, asText, asDiv) {
	//Text控件
	var vText = document.getElementById(asText);
	var strText = vText.value.trim();

	//空判断
	if (IsNull(strText) == false) {

		setDivError(asHidValidation, asText, asDiv, "TIME");
		return false;
	}

	//时间
	if (IsDate(strText) == false) {
		setDivError(asHidValidation, asText, asDiv, "TIME");
		return false;
	}
	if (asText == 'txtDate_1' || asText == 'txtDate_2') {
		//时间大小比较
		if (beTime_endTime() == false) {
			setDivError(asHidValidation, asText, asDiv, "TIME");
			return false;
		}
	} else {
		//时间大小比较2
		if (beTime_endTime2() == false) {
			setDivError(asHidValidation, asText, asDiv, "TIME");
			return false;
		}
	}
	setDivReight(asHidValidation, asText, asDiv);
	return true;

}

//text,时间验证
function getTimeNoBeginToEnd(asHidValidation, asText, asDiv) {
		//Text控件
		var vText = document.getElementById(asText);
		var strText = vText.value.trim();

		//空判断
		if (IsNull(strText) == false) {

			setDivError(asHidValidation, asText, asDiv, "TIME");
			return false;
		}

		//时间
		if (IsDate(strText) == false) {
			setDivError(asHidValidation, asText, asDiv, "TIME");
			return false;
		}

		setDivReight(asHidValidation, asText, asDiv);
		return true;

	}
	//text,时间验证,开始时间 结束时间比较
function beTime_endTime() {
		//Text控件
		var txtDate_1 = document.getElementById('txtDate_1').value.trim();
		var txtDate_2 = document.getElementById('txtDate_2').value.trim();

		if (txtDate_1 > txtDate_2) {
			return false;
		}
	}
	//text,时间验证,开始时间 结束时间比较
function beTime_endTime2() {
	//Text控件
	var txtDate_1 = document.getElementById('txtDate_3').value.trim();
	var txtDate_2 = document.getElementById('txtDate_4').value.trim();

	if (txtDate_1 > txtDate_2) {
		return false;
	}
}

//text,电话验证
function getTel(asHidValidation, asText, asDiv) {
	//Text控件
	var vText = document.getElementById(asText);
	var strText = vText.value.trim();

	//空判断
	if (IsNull(strText) == false) {
		setDivError(asHidValidation, asText, asDiv, "NULL");
		return false;
	}

	//数字
	if (IsStringInt(strText) == false) {
		setDivError(asHidValidation, asText, asDiv, "PHONENUNBER");
		return false;
	}

	setDivReight(asHidValidation, asText, asDiv);
	return true;

}

//text，数字认证
function getHowtime(asHidValidation, asText, asDiv) {
	//Text控件
	var vText = document.getElementById(asText);
	var strText = vText.value.trim();

	//空判断
	if (IsNull(strText) == false) {
		setDivError(asHidValidation, asText, asDiv, "NULL");
		return false;
	}
	//数字
	if (IsStringInt(strText) == false) {
		setDivError(asHidValidation, asText, asDiv, "PHONENUNBER");
		return false;
	}
	//数字
	if (IsInteger(strText) == false) {
		setDivError(asHidValidation, asText, asDiv, "PHONENUNBER");
		return false;
	}

	setDivReight(asHidValidation, asText, asDiv);
	return true;

}

//text,E-mail验证
function getMail(asHidValidation, asText, asDiv) {
	//Text控件
	var vText = document.getElementById(asText);
	var strText = vText.value.trim();

	//空判断
	if (IsNull(strText) == false) {
		setDivError(asHidValidation, asText, asDiv, "NULL");
		return false;
	}

	//mail
	if (IsEmail(strText) == false) {
		setDivError(asHidValidation, asText, asDiv, "EMAIL");
		return false;
	}

	setDivReight(asHidValidation, asText, asDiv);
	return true;

}

//text,地址验证
function getAdd(asHidValidation, asText, asDiv) {
		//Text控件
		var vText = document.getElementById(asText);
		var strText = vText.value.trim();

		//空判断
		if (IsNull(strText) == false) {
			setDivError(asHidValidation, asText, asDiv, "NULL");
			return false;
		}
		//最大长度
		if (MaxValue(strText, '50') == false) {
			setDivError(asHidValidation, asText, asDiv, "MAXIMUM");
			return false;
		}

		setDivReight(asHidValidation, asText, asDiv);
		return true;

	}
	////////////////////////////////////////////////////////////
	////////////////////////////////////////////////////////////
	//text,文本长度验证
function getText(asHidValidation, asText, asDiv) {
	//Text控件
	var vText = document.getElementById(asText);
	var strText = vText.value.trim();

	//空判断
	if (IsNull(strText) == false) {
		setDivError(asHidValidation, asText, asDiv, "NULL");
		return false;
	}

	//最大长度
	if (MaxValue(strText, '200') == false) {
		setDivError(asHidValidation, asText, asDiv, "MAXIMUM");
		return false;
	}

	setDivReight(asHidValidation, asText, asDiv);
	return true;

}

//下拉选验证
function getSelect(asHidValidation, asText, asDiv) {
	//Text控件
	var vText = document.getElementById(asText);
	var strText = vText.value.trim();

	//空判断
	if (IsNull(strText) == false) {
		setDivError(asHidValidation, asText, asDiv, "NULL");
		return false;
	}

	//是否选择则了有效选项
	if (strText == 0) {
		setDivError(asHidValidation, asText, asDiv, "SELECTED");
		return false;
	}

	setDivReight(asHidValidation, asText, asDiv);
	return true;

}

//时间格式验证 （00:00:00）
function getIsTime(asHidValidation, asText, asDiv) {
		//Text控件
		var vText = document.getElementById(asText);
		var strText = vText.value.trim();

		//空判断
		if (IsNull(strText) == false) {
			setDivError(asHidValidation, asText, asDiv, "NULL");
			return false;
		}

		//是否是时间格式
		if (IsTime(strText)) {
			setDivError(asHidValidation, asText, asDiv, "TIME");
			return false;
		}

		setDivReight(asHidValidation, asText, asDiv);
		return true;

	}
	/////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////
	//----------------------------------------------------

//DIV,颜色等设置
//----------------------------------------------------
//出错后设置DIV等
function setDivError(asHidValidation, asText, asDiv, asMessageType) {
	//DIV控件
	var vDiv = document.getElementById(asDiv);

	//Text控件
	var vText = document.getElementById(asText);

	//隐藏控件
	var vHid = document.getElementById(asHidValidation);

	//div显示信息
	vDiv.innerHTML = getMessage(asMessageType);
	vDiv.style.background = "#FF0000";
	vDiv.style.color = "#FFFFFF";

	//Tex显示信息
	vText.style.borderColor = "#FF0000";

	//隐藏控件 1:出错   0：正确  整理验证用一个隐藏控件
	vHid.value = "1";

}

//正确设置DIV等
function setDivReight(asHidValidation, asText, asDiv) {

		//DIV控件
		var vDiv = document.getElementById(asDiv);

		//Text控件
		var vText = document.getElementById(asText);

		//隐藏控件
		var vHid = document.getElementById(asHidValidation);

		//div显示信息
		vDiv.style.background = "#eef7fe";
		vDiv.style.color = "#FFFFFF";
		vDiv.innerHTML = "";

		//Tex显示信息
		vText.style.borderColor = "#46A3FF";

		//隐藏控件 1:出错   0：正确  整理验证用一个隐藏控件
		vHid.value = "0";
	}
	//----------------------------------------------------

//出错信息
//----------------------------------------------------
function getMessage(asType) {
		switch (asType) {
			case 'NULL':
				return "对不起，文本框不能为空或者为空格!"; //判断输入内容是否为空
			case 'DATE':
				return "对不起，您输入的日期格式不正确!"; //判断日期类型是否为YYYY-MM-DD格式的类型
			case 'DATETIME':
				return "对不起，您输入的日期时间格式不正确!"; //判断日期类型是否为YYYY-MM-DD hh:mm:ss格式的类型
			case 'TIME':
				return "对不起，您输入的时间格式不正确!"; //判断日期类型是否为hh:mm:ss格式的类型
			case 'LETTER':
				return "对不起，您输入的不是英文字母!"; //判断输入的字符是否为英文字母
			case 'INTEGER':
				return "对不起，您输入的不是整数!"; //判断输入的字符是否为整数
			case 'DOUBLE':
				return "对不起，您输入的双精度类型格式不正确!"; //判断输入的字符是否为双精度
			case 'STRING':
				return "对不起，您输入的字符中不能有特殊字符!"; //判断输入的字符是否为:a-z,A-Z,0-9
			case 'CHINESE':
				return "对不起，您输入的不是中文!"; //判断输入的字符是否为中文
			case 'EMAIL':
				return "对不起，您输入的EMAIL格式不正确!"; //判断输入的EMAIL格式是否正确
			case 'ZIP':
				return "对不起，您输入的邮编格式不正确!"; //判断输入的邮编(只能为六位)是否正确
			case 'MAXVALUE':
				return "对不起，您输入的数字超出范围!"; //判断输入的数字不大于某个特定的数字
			case 'RE':
				return "对不起，用户名已存在!"; //用户名存在
				//后加
			case 'MAXIMUM':
				return "对不起，您输入的字符个数超出范围!"; //判断输入的字符超出最大范围
			case 'MINIMUM':
				return "对不起，您输入的字符个数小于三个!"; //判断输入的字符小于五个
			case 'PHONENUNBER':
				return "对不起，您输入的电话号格式不正确!"; //判断输入的电话号格式
			case 'PASSDISPARITY':
				return "对不起，您输入的俩个密码不相同!"; //判断输入的俩个密码不相同
			case 'IDENTIFICATION':
				return "对不起，您输入的身份证号格式不正确!"; //判断输入的俩个密码不相同
			case 'PASSMINIMUM':
				return "对不起，您输入的密码字符个数小于五个!"; //判断输入的俩个密码不相同

				////////////////////////////////////////////////////////////////////////////////////////////////
			case 'SELECTED':
				return "对不起，您没有选择下拉选!"; //判断是否选择下拉选的有效值
			case 'CHECK':
				return "对不起，没有检查你输入的是否可用!"; //判断输入的有没有检查
		}
	}
	//----------------------------------------------------

//验证判断
//----------------------------------------------------
//判断输入内容是否为空
function IsNull(strText) {
	if (strText.length == 0) {
		return false;
	} else {
		return true;
	}
}

//判断日期类型是否为YYYY-MM-DD格式的类型
function IsDate(str) {

	if (str.length != 0) {
		var reg = /^(\d{4})(\d{2})(\d{2})$/;
		var r = str.match(reg);
		if (r == null) {
			return false;
		} else {
			return true;
		}
	}
}

//判断日期类型是否为YYYY-MM-DD hh:mm:ss格式的类型
function IsDateTime(str) {

	if (str.length != 0) {
		var reg = /^(\d{1,4})(-|\/)(\d{1,2})\2(\d{1,2}) (\d{1,2}):(\d{1,2}):(\d{1,2})$/;
		var r = str.match(reg);
		if (r == null) {
			return false;
		} else {
			return true;
		}
	}
}

//判断日期类型是否为hh:mm:ss格式的类型
function IsTime(str) {
	if (str.length != 0) {
		reg = /^((20|21|22|23|[0-1]\d)\:[0-5][0-9])(\:[0-5][0-9])?$/

		if (reg.test(str)) {
			return false;
		} else {
			return true;
		}
	}
}

//判断输入的字符是否为英文字母
function IsLetter(str) {
	if (str.length != 0) {
		reg = /^[a-zA-Z]+$/;

		if (!reg.test(str)) {
			return false;
		} else {
			return true;
		}
	}
}

//判断输入的字符是否为整数
function IsInteger(str) {
	if (str.length != 0) {
		reg = /^[-+]?\d*$/;
		if (!reg.test(str)) {
			return false;
		} else {
			return true;
		}
	}
}

//判断输入的字符是否为双精度
function IsDouble(str, val) {
	if (str.length != 0) {
		reg = /^[-\+]?\d+(\.\d+)?$/;
		if (!reg.test(str)) {
			return false;
		} else {
			return true;
		}
	}
}

//判断输入的字符是否为:a-z,A-Z,0-9
function IsString(str) {
	if (str.length != 0) {
		reg = /^[a-zA-Z0-9_]+$/;

		if (!reg.test(str)) {
			return false;
		} else {
			return true;
		}
	}
}

//判断输入的字符是否为:0-9
function IsStringInt(str) {
	if (str.length != 0) {
		reg = /^[0-9_]+$/;

		if (!reg.test(str)) {
			return false;
		} else {
			return true;
		}
	}
}

//判断输入的字符是否为中文
function IsChinese(str) {
	if (str.length != 0) {
		reg = /^[\u0391-\uFFE5]+$/;

		if (!reg.test(str)) {
			return false;
		} else {
			return true;
		}
	}
}

//判断输入的EMAIL格式是否正确
function IsEmail(str) {
	if (str.length != 0) {
		reg = /^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/;

		if (!reg.test(str)) {
			return false;
		} else {
			return true;
		}
	}
}

//判断输入的邮编(只能为六位)是否正确
function IsZIP(str) {
	if (str.length != 0) {
		reg = /^\d{6}$/;

		if (!reg.test(str)) {
			return false;
		} else {
			return true;
		}
	}
}

//判断输入的数字不大于某个特定的数字
function MaxValue(str, strLength) {
	if (str.length != 0) {
		reg = /^[-+]?\d*$/;

		//判断是否为数字类型
		if (str.length > parseInt(strLength)) //“123”为自己设定的最大值
		{
			return false;
		} else {
			return true;
		}

	}
}

//----------------------------------------------------
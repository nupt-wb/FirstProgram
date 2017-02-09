function divHide(){
	$("#divName").hide();
	$("#divPwd").hide();
}

function registerCheck(){
	divHide();
	var namePattern = /^[a-zA-Z]{1}([a-zA-Z0-9]|[_]){5,20}$/;
	var numberPattern = /([a-zA-Z0-9]|[_]){6}/;
	var digitalPattern = /[0-9]{1,}/;
	var wordPattern = /[a-zA-Z]{1,}/;
	var specialPattern = /[_]{1,}/;
	
	var txtName = $("#txtName").val();
	var txtPwd = $("#txtPwd").val();
	
	if(!namePattern.exec(txtName)){
		$("#divName").show();
		return false;
	}else{
		if(numberPattern.exec(txtPwd) && digitalPattern.exec(txtPwd) &&
		   wordPattern.exec(txtPwd) && specialPattern.exec(txtPwd)){
			document.userRegister.submit();
			return true;
		}else{
			$("#divPwd").show();
			return false;
		}
		
	}
	
}

function loginCheck(){
	divHide();
	var namePattern = /^[a-zA-Z]{1}([a-zA-Z0-9]|[_]){5,20}$/;
	var numberPattern = /([a-zA-Z0-9]|[_]){6}/;
	var digitalPattern = /[0-9]{1,}/;
	var wordPattern = /[a-zA-Z]{1,}/;
	var specialPattern = /[_]{1,}/;
	
	var txtName = $("#txtName").val();
	var txtPwd = $("#txtPwd").val();
	
	if(!namePattern.exec(txtName)){
		$("#divNameLogin").show("用户名错误");
		return false;
	}else{
		if(numberPattern.exec(txtPwd) && digitalPattern.exec(txtPwd) &&
		   wordPattern.exec(txtPwd) && specialPattern.exec(txtPwd)){
			if(CookieValidate()){
				//cookie验证通过，直接跳转到投票界面
			//	alert("")
				document.getElementById("userRegister").action="vote";
				//window.location.href="http://localhost:8080/FirstProgram/vote";
			}else{
				//cookie验证失败，跳转后台验证
				document.getElementById("userRegister").action="LoginProcess";
			//	window.location.href="http://localhost:8080/FirstProgram/LoginProcess";
			}
			document.userRegister.submit();
			return true;
			
		}else{
			$("#divPwdLogin").show("密码错误");
			return false;
		}
		
	}
}

function CookieValidate(){
	var name = $.cookie("name");
	var pwd = $.cookie("pwd");
	
	var txtName = $("#txtName").val();
	var txtPwd = $("#txtPwd").val();
	
    if(name == txtName && pwd ==txtPwd){
    	return true;  	
    }else{
    	return false;
    } 
	
}
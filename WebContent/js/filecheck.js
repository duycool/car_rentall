 					var inputgiotra = document.getElementById('giotra');
                       	var inputphuttra = document.getElementById('phuttra');
                       	var inputhour =  document.getElementById('hour');
                       	var inputminute = document.getElementById('minute');
                       	
                       	var formlogin = document.getElementById('form-login');
                       	if(formlogin.attachEvent){
                       		form.attachEvent('submit',onFormSubmit);
                       	}else{
                       		form.addEventListener('submit',onFormSubmit);
                       	}
                       	function onFormSubmit(e){
                       		var giotra = inputgiotra.value;
                       		var phuttra = inputphuttra.value;
                       		var hour = inputhour.value;
                       		var minute = inputminute.value;
                       		
                       		if(giotra == hour && phuttra == munute){
                       			alert('Dang ky thanh cong');
                       			return true;
                       		}else{	                       			
                       			alert('Dang ky khong thanh cong');
                       			return false;
                       		}
                       	}
function savePos(textBox){
	if(typeof(textBox.selectionStart) == "number"){
		start = textBox.selectionStart;
		end = textBox.selectionEnd;
	}
	else if(document.selection){
		try{
			var range = document.selection.createRange();
			if(range.parentElement().id == textBox.id){
			
				var range_all = document.body.createTextRange();
				range_all.moveToElementText(textBox);
				for (start=0; range_all.compareEndPoints("StartToStart", range) < 0; start++)
				 range_all.moveStart('character', 1);
				for (var i = 0; i <= start; i ++){
					if (textBox.value.charAt(i) == '\n')
					start++;
				}
				
				 var range_all = document.body.createTextRange();
				 range_all.moveToElementText(textBox);
				 for (end = 0; range_all.compareEndPoints('StartToEnd', range) < 0; end ++)
					 range_all.moveStart('character', 1);
				 for (var i = 0; i <= end; i ++)
				 {
					 if (textBox.value.charAt(i) == '\n')
					 end ++; 
				 }
			}
		}catch(e){;}
	}
}

	
function conLen(obj){
var len = obj.value.length;
o('clen').innerHTML=len;
v_cf_cur = Math.ceil(len/v_char_size);
o('cf').innerHTML=v_cf_cur;
mSum()
o('lsum').innerHTML =v_mobile_sum*v_cf_cur;}





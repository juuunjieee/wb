/**
 * jQuery EasyUI 1.5
 * 
 * Copyright (c) 2009-2016 www.jeasyui.com. All rights reserved.
 *
 * Licensed under the freeware license: http://www.jeasyui.com/license_freeware.php
 * To use it on other terms please contact us: info@jeasyui.com
 *
 */
/**
 * form - jQuery EasyUI
 * 
 */

if (!Array.indexOf) {  
    Array.prototype.indexOf = function (obj) {  
        for (var i = 0; i < this.length; i++) {  
            if (this[i] == obj) {  
                return i;  
            }  
        }  
        return -1;  
    }  
} 
(function($){

	function endwith(src,s){
	  if(s==null||s==""||src.length==0||s.length>src.length)
	     return false;
	  if(src.substring(src.length-s.length)==s)
	     return true;
	  else
	     return false;
	  return true;
	};
	

	/**
	 * clear the form fields
	 */
	function clear(target){

		var form = $(target);
		var opts = $.data(target, 'form').options;
		for(var i=opts.fieldTypes.length-1; i>=0; i--){
			var type = opts.fieldTypes[i];
			var field = form.find('.'+type+'-f');
			field.each(function(){
				if ($(this)[type] ){
					var claz=$(this).attr("class");
					var clazArray=claz.split(' ');

					if(clazArray.length<=0) return false;

					clazArray=$.map(clazArray,function(e){
						if(endwith($.trim(e),'-f')){
							return $.trim(e);
						}
					});
					var tmpclaz=''+type+'-f'
					if(clazArray.indexOf(tmpclaz)==0 && !$(this).hasClass('my-clear-ed')){
						$(this)[type]('clear');
						$(this).addClass('my-clear-ed');
					}//if
				}//if
			});//each

		}//for
		
		// 更新非easyui控件
		$('input,select,textarea', target).each(function(){
			if ($(this).hasClass('my-clear-ed')){
				return true;
			}
			if($(this).closest('span.textbox').length){
				return true;
			}
			var t = this.type, tag = this.tagName.toLowerCase();
			if (t == 'text' || t == 'hidden' || t == 'password' || tag == 'textarea'){
				this.value = '';
			} else if (t == 'file'){
				var file = $(this);
				if (!file.hasClass('textbox-value')){
					var newfile = file.clone().val('');
					newfile.insertAfter(file);
					if (file.data('validatebox')){
						file.validatebox('destroy');
						newfile.validatebox();
					} else {
						file.remove();
					}
				}
			} else if (t == 'checkbox' || t == 'radio'){
				this.checked = false;
			} else if (tag == 'select'){
				this.selectedIndex = -1;
			}
			
		});
		$('.my-clear-ed').removeClass('my-clear-ed');
		clearEasyUiInvalidTip(target);
	}
	
	function reset(target){

		clear(target);
	}
	
	var _tmep_form_load=$.fn.form.methods.load;
    $.extend($.fn.form.methods, {
		load: function(jq,data){
			var ret=_tmep_form_load(jq,data);
			clearEasyUiInvalidTip(jq);
			return ret;
		},
        clear: function(jq){
			return jq.each(function(){
				clear(this);
			});
		},
		reset: function(jq){
			return jq.each(function(){
				reset(this);
			});
		},
		/**
		  设置本form的改变标志位
		*/
		clearChangeFlag:function(jq){
			jq.data('changeFlag',false);
		},
		setChangeFlag:function(jq){
			jq.data('changeFlag',true);
		},
		/**
		 是否改变
		*/
		isChanged:function(jq){
			var ret= jq.data('changeFlag');
			if(ret){
				return true;
			}else{
				return false;
			}

		}
    });
	
    $.extend($.fn.form.defaults,{
    	iframe:false,
    	
        onChange:function(target){
			var opts=$(this).form('options');
			if(opts.ignoreSetChangeFlag){
				var ignore=ignoreSetChangeFlag(target);
				if(!ignore){
					$(this).data('changeFlag',true);
					return;
				}

			}else{
					$(this).data('changeFlag',true);
			}
			
		}
    });
	

})(jQuery);


var _easyui_input_class_=".spinner-f,.slider-f,.switchbutton-f,.textbox-f,.textbox-value ,.slider-value,.switchbutton-value,.textbox-text"

/***
 监听form下非easyui 输入控件的改变
*/

$(function(){
	$('form').form({});
	var _init=true;
	$( document ).ajaxStop(function() {
		  if(window['all_ajax_loaded_on_init']){
			  if(_init){
				window.all_ajax_loaded_on_init();
				clearEasyUiInvalidTip("body");
				$('form').form("clearChangeFlag");
			  }
			  _init=false;
		  };
		  
		  

	});
	$( window ).on( "load", function(){
		 clearEasyUiInvalidTip("body");
		 $('form').form("clearChangeFlag");
	})
	
	
 });


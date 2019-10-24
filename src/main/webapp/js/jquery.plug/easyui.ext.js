
/***
判断是否为非easyui输入控件
*/

function isEasyuiInput(selector){
	if($(selector).is(":input")){
       if($(selector).is(_easyui_input_class_))
		{
		   return true;
		}
	}
	return false;
}

/****
 * ajax全局控制
 */

function bindTimeOutEvent(linkbutton){
	var opts=$(linkbutton).linkbutton("options");
	var timeout=0;
	if(opts.timeout !=undefined){
		if(opts.timeout<=0){
			timeout=0;
		}else{
			timeout=opts.timeout;
		}
	}
	if(timeout>0){
		setTimeout(function(){
			$(linkbutton).linkbutton("disable");
		},1);
		
		setTimeout(function(){
			$(linkbutton).linkbutton("enable");
		},timeout);
	}
}

$(function(){
	// 全局的ajax访问，处理ajax清求时sesion超时
	$.ajaxSetup({
		cache : false,
		global:true,
		crossDomain :true,
		contentType : "application/x-www-form-urlencoded;charset=utf-8",
		timeout : 1000*60*15
	});
	

	/**
	 * 解决ajax重复提交的问题,此处可以全局作缓存
	 */
	var pendingRequests = {};
	
	function mySign(options){
		if(options){//签名
    		var str=options.url;
    		var queryStr="";
			if((!str||str.indexOf("?")<0 )&&(!options.data || options.data=='')){//不用签名
				return;
			}
			
			var index=str.indexOf("?");
			
			if(index>=0 && str.length-1>index){
				queryStr=str.substr(index+1);
			}
			if(options.data && options.data!='' && (typeof options.data == "string") ){
				if(queryStr!=''){
					queryStr=queryStr+"&"+options.data
				}else{
					queryStr=options.data;
				}
			}
			var sign="";
			var md5toStr="";
			//console.log("queryStr="+queryStr);
			if(queryStr==''){
				//console.log("md5toStr="+md5toStr+_global_token);
				sign=md5(md5toStr+_global_token);
				
				if(options.url.indexOf("?")>0){
	    			options.url=options.url+"&sign="+sign;
	    		}else{
	    			options.url=options.url+"?sign="+sign;
	    		}
				return;
			}
		
			var qo=parseSearchString(queryStr);
			//console.log("qo="+$.toJSON(qo));
			
			//排序qo的键
			var keys=Object.keys(qo);
			//console.log("keys="+$.toJSON(keys));
			if(keys && isArray(keys) && keys.length>0){
				keys.sort();
				
				for(var index=0; index<keys.length; index++){
					var val=qo[keys[index]];
					if(isArray(val)){
						val.sort();
						val=val.join(",");
					}
					md5toStr=md5toStr+"&"+keys[index]+"="+val;
				}
			
				//console.log("md5toStr="+md5toStr+_global_token);
				sign=md5(md5toStr+_global_token);
				//console.log("sign="+sign);
	    		if(options.url.indexOf("?")>0){
	    			options.url=options.url+"&sign="+sign;
	    		}else{
	    			options.url=options.url+"?sign="+sign;
	    		}
			}
			
    	
		
    		
    	}
	}
    jQuery.ajaxPrefilter(function( options, originalOptions, jqXHR ) {
    	//console.log(options);
    	mySign(options);

        var complete = options.complete;
        options.complete = function(jqXHR, textStatus) {
			check_time_out(jqXHR);
           // pendingRequests[key] = null;
            if (jQuery.isFunction(complete)) {
            	complete.apply(this, arguments);
            }
        };
		var success = options.success;
		options.success=function(data, textStatus, jqXHR ){
			check_time_out(jqXHR);
			//pendingRequests[key] = null;
			if(jQuery.isFunction(success)){
				success.apply(this, arguments);
			}
		}
		var error = options.error;
		options.error=function(event, jqxhr, settings, thrownError){
			check_time_out(jqXHR);
			//pendingRequests[key] = null;
			if(jQuery.isFunction(error)){
				error.apply(this, arguments);
			}
		}
    });
	
	function check_time_out(XMLHttpRequest){
		if(XMLHttpRequest.getResponseHeader){
			var sessionstatus = XMLHttpRequest
			.getResponseHeader("sessionstatus"); // 通过XMLHttpRequest取得响应头，sessionstatus，
			if(sessionstatus){
				if (sessionstatus == "timeout") {
					// 如果超时就处理 ，指定要跳转的页面
					
					var xmlDoc=XMLHttpRequest.responseText;
					var ret=eval('(' + xmlDoc + ')');//$.evalJSON(xmlDoc);
					
					alert(ret.content);
					if(window.top){
						window.top.location=ret.login;
					}else{
						window.location=ret.login;
					}
				}else if (sessionstatus == "control") {
					// 如果访问控制就处理 ，指定要跳转的页面
					
					var xmlDoc=XMLHttpRequest.responseText;
					var ret=eval('(' + xmlDoc + ')');//$.evalJSON(xmlDoc);
					
					alert(ret.content);
					if(ret.exit==1){
						if(window.top){
							window.top.location=ret.login;
						}else{
							window.location=ret.login;
						}
					}
				}
			}
			return false;
		}
		return true;
	}

		
});

(function($){
	if($.validatebox){
		$.extend($.fn.validatebox.defaults.rules, {
			validateOnCreate:true
		});
	}
	
	if ($.messager){
		$.extend($.messager.defaults,{
			width:400,
		    height:'auto',
			minHeight:200,
			modal:true
			
		});
		if($.messager.show){
			var show=$.messager.show;
			$.messager.show=function(options){
				if(!options.timeout ){
					options.timeout=4000;
				}else{
					options.timeout=4000;
				}
				return show(options);
			}
		};
		if($.messager.alert){
			var alert2=$.messager.alert;
			$.messager.alert=function(title, msg, icon, fn){
				if(!icon || icon==""){
					icon="info";
				}
				return alert2(title, msg, icon, fn);
			}
		};
		
		
		
		if($.messager.confirm){
			var confirm2=$.messager.confirm;
			$.messager.confirm=function(title, msg, fn){
				return confirm2({'title':title,'msg':msg,'fn':fn,'ok':'是','cancel':'否'});
			}
		}
		
		if ($.messager){
			//$.messager.defaults.ok = '是';
			//$.messager.defaults.cancel = '否';
		}
	}
	/***改写默认控件的高度***/
	var my_default_height=26;
	if($.fn.textbox)$.fn.textbox.defaults.height=my_default_height;
	
	if($.fn.combo) {
		function _13(_28) {
			var _29 = $.data(_28, "combo").panel;
			_29.panel("close");
		}
		function _1aa(e) {
			var _1b = e.data.target;
			var t = $(_1b);
			var _1c = t.data("combo");
			var temp = t.data("combo").combo;
			var _1d = t.combo("options");
			_1c.panel.panel("options").comboTarget = _1b;
			switch (e.keyCode) {
			case 38:
				_1d.keyHandler.up.call(_1b, e);
				break;
			case 40:
				_1d.keyHandler.down.call(_1b, e);
				break;
			case 37:
				_1d.keyHandler.left.call(_1b, e);
				break;
			case 39:
				_1d.keyHandler.right.call(_1b, e);
				break;
			case 13:
				e.preventDefault();
				_1d.keyHandler.enter.call(_1b, e);
				return false;
			case 9:
			case 27:
				_13(_1b);
				break;
			default:
				if (_1d.editable) {
					if (_1c.timer) {
						clearTimeout(_1c.timer);
					}
					_1c.timer = setTimeout(function() {
						var q = t.combo("getText");
						if (_1c.previousText != q) {
							_1c.previousText = q;
							t.combo("showPanel");
							_1d.keyHandler.query.call(_1b, q, e);
							t.combo("validate");
						}
					}, _1d.delay);
					
					temp.find(".textbox-text").bind("input", function (e) {
				        if(_1c.timer){
				            clearTimeout(_1c.timer);
				        }
				        _1c.timer=setTimeout(function(){
				            var q=t.combo("getText");
				            if(_1c.previousText!=q){
				            	_1c.previousText=q;
				                t.combo("showPanel");
				                _1d.keyHandler.query.call(_1b,q,e);
				                t.combo("validate");
				            }
				        },_1d.delay);
				    });
				}
			}
		}
			
		$.fn.combo.defaults.height=my_default_height;
		$.fn.combo.defaults.inputEvents.keydown=_1aa;
		$.fn.combo.defaults.inputEvents.paste=_1aa;
		$.fn.combo.defaults.inputEvents.drop=_1aa;
		
		
	}
	if($.fn.combobox){
		$.fn.combobox.defaults.height=my_default_height;
		$.fn.combobox.defaults.inputEvents.keydown=_1aa;
		$.fn.combobox.defaults.inputEvents.paste=_1aa;
		$.fn.combobox.defaults.inputEvents.drop=_1aa;
	}
	if($.fn.numberbox) $.fn.numberbox.defaults.height=my_default_height;
	if($.fn.datebox) $.fn.datebox.defaults.height=my_default_height;
	if($.fn.datetimebox) $.fn.datetimebox.defaults.height=my_default_height;
	if($.fn.filebox) $.fn.filebox.defaults.height=my_default_height;
	if($.fn.combotree)  $.fn.combotree.defaults.height=my_default_height;//combogrid
	if($.fn.combogrid)  $.fn.combogrid.defaults.height=my_default_height;//passwordbox
	if($.fn.combotreegrid)  $.fn.combotreegrid.defaults.height=my_default_height;
	if($.fn.passwordbox)  $.fn.passwordbox.defaults.height=my_default_height;//numberspinner
	if($.fn.datetimespinner)  $.fn.datetimespinner.defaults.height=my_default_height;
	if($.fn.numberspinner)  $.fn.numberspinner.defaults.height=my_default_height;
	if($.fn.timespinner)  $.fn.timespinner.defaults.height=my_default_height;
	

	/**1.修复linkbutton的disable和enable不对称触发时，引起的href事件丢失的问题
	 * 2.对linkbutton增加timeout属性，指定多长时间解禁按钮，默认1000秒
	 * 
	 * */

    if($.fn.linkbutton){
    	$.fn.linkbutton.defaults.height=my_default_height;
		function setDisabled(target, disabled){
			var state = $.data(target, 'linkbutton');
			var opts = state.options;
			$(target).removeClass('l-btn-disabled l-btn-plain-disabled');
			if (disabled){
				opts.disabled = true;

				var href = $(target).attr('href');
				if (href){
					if(!state.href){
						state.href = href;
					}
					$(target).attr('href', 'javascript:void(0)');
				}
				if (target.onclick){
					if(!state.onclick){
						state.onclick = target.onclick;
					}
					target.onclick = null;
				}
				opts.plain ? $(target).addClass('l-btn-disabled l-btn-plain-disabled') : $(target).addClass('l-btn-disabled');
			} else {
				opts.disabled = false;
				if (state.href) {
					$(target).attr('href', state.href);
				}
				if (state.onclick) {
					target.onclick = state.onclick;
				}
			}
	   }

	   $.extend($.fn.linkbutton.methods,{
		   	enable: function(jq){
				return jq.each(function(){
					setDisabled(this, false);
				});
			},
			disable: function(jq){
				return jq.each(function(){
					setDisabled(this, true);
				});
			}
	   });
	   
	   
	   $(function(){
		   $(".easyui-linkbutton").bind('click.my', function(){	
			   bindTimeOutEvent(this);
			});
	   });


	}
    
	if ($.fn.layout){
		$.fn.layout.paneldefaults.border=false;
	};
	
	/**
	 * datagrid默认的分页
	 */
	if ($.fn.datagrid){
		$.fn.datagrid.defaults.loadMsg = '正在处理，请稍待。。。';
		/*修改分页信息 by liujp*/
		$.fn.datagrid.defaults.pageSize =20;
		$.fn.datagrid.defaults.pageList =[20,50,100];
		$.fn.datagrid.defaults.border=false;
	};
	if ($.fn.combo){
		$.fn.combobox.defaults.panelHeight=120;
		$.fn.combobox.defaults.limitToList=true;
	};
	
	
	/**修正easyui的编辑时，对数字判断会改变的问题**/
	if($.fn.datagrid){ 
		function _2(a,o){
			return $.easyui.indexOfArray(a,o);
		};
		function _5(_6,aa){
			return $.data(_6,"treegrid")?aa.slice(1):aa;
		};
		function _164(_175,_176){
			var opts=$.data(_175,"datagrid").options;
			var tr=opts.finder.getTr(_175,_176);
			tr.children("td").each(function(){
			var cell=$(this).find("div.datagrid-editable");
			if(cell.length){
			var ed=$.data(cell[0],"datagrid.editor");
			if(ed.actions.destroy){
			ed.actions.destroy(ed.target);
			}
			cell.html(ed.oldHtml);
			$.removeData(cell[0],"datagrid.editor");
			cell.removeClass("datagrid-editable");
			cell.css("width","");
			}
			});
		};
		function _157(_177,_178){
				var tr=$.data(_177,"datagrid").options.finder.getTr(_177,_178);
				if(!tr.hasClass("datagrid-row-editing")){
				return true;
				}
				var vbox=tr.find(".validatebox-text");
				vbox.validatebox("validate");
				vbox.trigger("mouseleave");
				var _179=tr.find(".validatebox-invalid");
				return _179.length==0;
		};
		function _158(_159,_15a,_15b){
			var _15c=$.data(_159,"datagrid");
			var opts=_15c.options;
			var _15d=_15c.updatedRows;
			var _15e=_15c.insertedRows;
			var tr=opts.finder.getTr(_159,_15a);
			var row=opts.finder.getRow(_159,_15a);
			if(!tr.hasClass("datagrid-row-editing")){
				return;
			}
			if(!_15b){
				if(!_157(_159,_15a)){
					return;
				}
				var _15f=false;
				var _160={};
				tr.find("div.datagrid-editable").each(function(){
					var _161=$(this).parent().attr("field");
					var ed=$.data(this,"datagrid.editor");
					var t=$(ed.target);
					var _162=t.data("textbox")?t.textbox("textbox"):t;
					if(_162.is(":focus")){
						_162.triggerHandler("blur");
					}
					var _163=ed.actions.getValue(ed.target);
					if($.isNumeric(row[_161]) && $.isNumeric(_163)){
						_163=_163-0;
					}
					if(row[_161]!==_163){
						row[_161]=_163;
						_15f=true;
						_160[_161]=_163;
					}
				});
				if(_15f){
					if(_2(_15e,row)==-1){////
						if(_2(_15d,row)==-1){
							_15d.push(row);
						}
					}
				}
				opts.onEndEdit.apply(_159,_5(_159,[_15a,row,_160]));
			}
			tr.removeClass("datagrid-row-editing");
			_164(_159,_15a);/////
			$(_159).datagrid("refreshRow",_15a);
			if(!_15b){
				opts.onAfterEdit.apply(_159,_5(_159,[_15a,row,_160]));////
			}else{
				opts.onCancelEdit.apply(_159,_5(_159,[_15a,row]));////
			}
		};/////
		$.extend($.fn.datagrid.methods,{
			getChecked:function(jq){
				var panel=$(jq).datagrid("getPanel");
				var rows=$(jq).datagrid("getRows");
				var ckrows=[];
				panel.find("div.datagrid-cell-check input[type=checkbox]").each(function(){
					
					var checked=$(this).is(':checked');
					if(checked){
						var rowIndex=$(this).closest("tr[datagrid-row-index]").attr("datagrid-row-index")-0;
						ckrows.push(rows[rowIndex]);
					}
				});
				return ckrows;
			},
			/**
			 * 修正edit单元格数字编辑时，用户不进行改变其值，只是点击进行编辑后再退出，但easyui总返回有改变的问题(通过getChanges得知)
			 */
			endEdit:function(jq,index){
				return jq.each(function(){
					_158(this,index,false);
					$(this).mydatagrid ("highlightRowLikeSelect",index);
					$(this).datagrid ("checkRow",index);
				});
			},
			cancelEdit:function(jq,index){
				return jq.each(function(){
					_158(this,index,true);
					$(this).mydatagrid ("highlightRowLikeSelect",index);
					$(this).datagrid ("checkRow",index);
				});
			},
			
		});	
		
	 /*EasyUI系列之扩展easyui datagrid的四个方法.动态禁用，启用toolbar*/
	  $.extend($.fn.datagrid.methods, { 
		/**
		* title:名称
		*/
		 disableToolBar:function(jq,title){
			 return jq.each(function(){  
				 var bars= $(this).parent().prev("div.datagrid-toolbar").find("a.l-btn-plain");
				 bars.each(function(){
					 var bar=$(this).find("span.l-btn-text:contains('"+title+"')");
					 if(bar.length>0){
						$(this).linkbutton("disable");
					 }
				 });
				
				 
			 });
		 },
		 enableToolBar:function(jq,title){
			  return jq.each(function(){  
				 var bars= $(this).parent().prev("div.datagrid-toolbar").find("a.l-btn-plain");
				 bars.each(function(){
					 var bar=$(this).find("span.l-btn-text:contains('"+title+"')");
					 if(bar.length>0){
						$(this).linkbutton("enable");
					 }
				 });
				
				 
			 });
		 }               
	 });

		
	}
	 /***优化easyui combobox设值问题 ***/
    var _temp_combobox_method_loadData=$.fn.combobox.methods.loadData;
	if($.fn.combobox){
		$.extend($.fn.combobox.methods,{
			loadData:function(jq,data){
				var ret=_temp_combobox_method_loadData(jq,data);
				clearEasyUiInvalidTip('form');
				return ret;
				 
			}
		});
	}
	
	var ie = (function(){
        var undef, v = 3, div = document.createElement('div'), all = div.getElementsByTagName('i');
        while (div.innerHTML = '<!--[if gt IE ' + (++v) + ']><i></i><![endif]-->', all[0]);
        return v > 4 ? v : undef;
    }());
	/**
     * add by cgh
     * 针对panel window dialog三个组件调整大小时会超出父级元素的修正
     * 如果父级元素的overflow属性为hidden，则修复上下左右个方向
     * 如果父级元素的overflow属性为非hidden，则只修复上左两个方向
     * @param width
     * @param height
     * @returns
     */
    var easyuiPanelOnResize = function(width, height){
		if(!$.data(this,'window') && !$.data(this,'dialog')) return;
		
		if(ie===8){
			var data = $.data(this, "window") || $.data(this, "dialog");
			if(data.pmask){
				var masks = data.window.nextAll('.window-proxy-mask');
				if(masks.length > 1){
					$(masks[1]).remove();
            		masks[1] = null;
				}
			}
		}
		if($(this).panel('options').maximized==true){
			$(this).panel('options').fit=false;
		}
        $(this).panel('options').reSizing = true;
		if(!$(this).panel('options').reSizeNum){
			$(this).panel('options').reSizeNum = 1;
		}else{
			$(this).panel('options').reSizeNum++;
		}		
        var parentObj = $(this).panel('panel').parent();
        var left = $(this).panel('panel').position().left;
        var top = $(this).panel('panel').position().top;
        
        if ($(this).panel('panel').offset().left < 0) {
            $(this).panel('move', {
                left: 0
            });
        }
        if ($(this).panel('panel').offset().top < 0) {
            $(this).panel('move', {
                top: 0
            });
        }
        
        if (left < 0) {
            $(this).panel('move', {
                left: 0
            }).panel('resize', {
                width: width 
            });
        }
        if (top < 0) {
            $(this).panel('move', {
                top: 0
            }).panel('resize', {
                height: height
            });
        }
    
        $(this).panel('options').reSizing = false;
    };
    /**
     * add by cgh
     * 针对panel window dialog三个组件拖动时会超出父级元素的修正
     * 如果父级元素的overflow属性为hidden，则修复上下左右个方向
     * 如果父级元素的overflow属性为非hidden，则只修复上左两个方向
     * @param left
     * @param top
     * @returns
     */
    var easyuiPanelOnMove = function(left, top){
        if ($(this).panel('options').reSizing) 
            return;
        var parentObj = $(this).panel('panel').parent();
        var width = $(this).panel('options').width;
        var height = $(this).panel('options').height;
        var right = left + width;
        var buttom = top + height;
        var parentWidth = parentObj.width();
        var parentHeight = parentObj.height();
        
        if (left < 0) {
            $(this).panel('move', {
                left: 0
				
            });
			
        }
        if (top < 0) {
            $(this).panel('move', {
                top: 0
            });
        }
        

    };
    if($.fn.window){
		$.fn.window.defaults.onResize = easyuiPanelOnResize;
		$.fn.window.defaults.onMove = easyuiPanelOnMove;
	}

	if($.fn.dialog){
		$.fn.dialog.defaults.onResize = easyuiPanelOnResize;
		  $.fn.dialog.defaults.onMove = easyuiPanelOnMove;
	}
	
})(jQuery);

if($.fn.validatebox){
	$.extend($.fn.validatebox.defaults.rules, {
		minLength : { // 判断最小长度
			validator : function(value, param) {
				return value.length >= param[0];
			},
			message : '最少输入 {0} 个字符。'
		},
		maxLength : { // 判断最大长度
			validator : function(value, param) {
				return value.length <= param[0];
			},
			message : '最大输入 {0} 个字符。'
		},
		length:{validator:function(value,param){
			var len=$.trim(value).length;
				return len>=param[0]&&len<=param[1];
			},
				message:"输入内容长度必须介于{0}和{1}之间."
			},
		phone : {// 验证电话号码
			validator : function(value) {
				return /^(\d{3,4}\-)?\d{6,8}\-?\d+$/i.test(s);
			},
			message : '格式不正确,请使用下面格式:020-12345678'
		},
		mobile : {// 验证手机号码
			validator : function(value) {
				return /^(\+)?(86)?0?1\d{10}$/i.test(value);
			},
			message : '手机号码格式不正确'
		},
		idcard : {// 验证身份证
			validator : function(value) {
				return /^\d{15}(\d{2}[A-Za-z0-9])?$/i.test(value);
			},
			message : '身份证号码格式不正确'
		},
		intOrFloat : {// 验证整数或小数
			validator : function(value) {
				return /^\d+(\.\d+)?$/i.test(value);
			},
			message : '请输入数字，并确保格式正确'
		},
		intOrFloatWithPoint : {// 验证整数或小数
			validator : function(value,param) {
				return /^\d+(\.\d{1,2})?$/i.test(value);
			},
			message : '请输入数字，并确保格式正确'
		},
		interestRate : {// 验证利率  2位正整数
			validator : function(value) {
				/*return /^[1-9][0-9]?$/i.test(value);*/
				return /^[0-9][0-9]?([.][0-9]{1,2})?$/i.test(value);
			},
			message : '格式为1到2位正整数或保留最多2位小数!'
		},
		currency : {// 验证货币
			validator : function(value) {
				return /^\d+(\.\d+)?$/i.test(value);
			},
			message : '货币格式不正确'
		},
		money : {// 验证金额  非0开头的金额
			validator : function(value,param) {
				var patern="^[0-9]([0-9]{0,"+(param[0]-1)+"})$";
	        	var m=new RegExp(patern);
	        	if(!m.test(value)){
	        		 $.fn.validatebox.defaults.rules.money.message ="不大于"+param[0]+"位正整数!";
	        	}
	        	return m.test(value);
			},
			message : ''
		},
		qq : {// 验证QQ,从10000开始
			validator : function(value) {
				return /^[1-9]\d{4,9}$/i.test(value);
			},
			message : 'QQ号码格式不正确'
		},
		zeroNineNum : {// 验证0-9的数字
			validator : function(value) {
				return /^[0-9]+$/i.test(value);
			},
			message : '请输入0-9之间的数字'
		},
		integer : {// 验证整数
			validator : function(value) {
				return /^-?\d+$/i.test(value);
			},
			message : '请输入整数'
		},
		positiveInteger : {// 验证正整数
			validator : function(value) {
				return /^[+]?[1-9]+\d*$/i.test(value);
			},
			message : '请输入正整数'
		},
		chinese : {// 验证中文
			validator : function(value) {
				return /^[\u0391-\uFFE5]+$/i.test(value);
			},
			message : '请输入中文'
		},
		english : {// 验证英语
			validator : function(value) {
				return /^[A-Za-z]+$/i.test(value);
			},
			message : '请输入英文'
		},
		normal : {// 验证普通字符,包括英文数字中划线下划线
			validator : function(value) {
				return /^[a-zA-Z0-9_-]{1,40}$/i.test(value);
			},
			message : '请勿输入英文数字中划线下划线之外的字符'
		},
		unnormal : {// 验证是否包含空格和非法字符
			validator : function(value) {
				return /.+/i.test(value);
			},
			message : '输入值不能为空和包含其他非法字符'
		},
		username : {// 验证用户名
			validator : function(value) {
				return /^[a-zA-Z][a-zA-Z0-9_]{5,15}$/i.test(value);
			},
			message : '只允许字母开头，6-16字节，字母数字下划线'
		},
		realname : {// 验证真实名称,只能中文
			validator : function(value) {
				return /^[\u4E00-\u9FA5]+$/i.test(value);
			},
			message : '只允许中文'
		},
		content : {// 验证文本,包含中文、字母、数字
			validator : function(value) {
				return /^[\u4E00-\u9FA5A-Za-z0-9]+$/i.test(value);
			},
			message : '只允许中文、字母或数字'
		},
		multiText : {// 多条文本验证
			validator : function(value) {
				return /^((([\u4E00-\u9FA5A-Za-z0-9!@#$%^&*()_=《》<>.、，；?？;‘’\“”\"。,\-\+])*(\r*|\n*|\s*)?)*)?$/i.test(value);
			},
			message : '请勿输入特殊字符'
		},
		faxno : {// 验证传真
			validator : function(value) {
				return /^((\(\d{2,3}\))|(\d{3}\-))?(\(0\d{2,3}\)|0\d{2,3}-)?[1-9]\d{6,7}(\-\d{1,4})?$/i.test(value);
			},
			message : '传真号码不正确'
		},
		zip : {// 验证邮政编码
			validator : function(value) {
				return /^[1-9]\d{5}$/i.test(value);
			},
			message : '邮政编码格式不正确'
		},
		ip : {// 验证IP地址
			validator : function(value) {
				return /\d+.\d+.\d+.\d+/i.test(value);
			},
			message : 'IP地址格式不正确'
		},
		name : {// 验证姓名，可以是中文或英文
				validator : function(value) {
					return /^[\u0391-\uFFE5]+$/i.test(value)|/^\w+[\w\s]+\w+$/i.test(value);
				},
				message : '输入的值不能包含非法字符'
		},
		carNo:{
			validator : function(value){
				return /^[\u4E00-\u9FA5][\da-zA-Z]{6}$/.test(value); 
			},
			message : '车牌号码无效（例：粤J12350）'
		},
		carenergin:{
			validator : function(value){
				return /^[a-zA-Z0-9]{16}$/.test(value); 
			},
			message : '发动机型号无效(例：FG6H012345654584)'
		},
		email:{
			validator : function(value){
			return /^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/.test(value); 
		},
		message : '请输入有效的电子邮件账号(例：abc@126.com)'    
		},
		msn:{
			validator : function(value){
			return /^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/.test(value); 
		},
		message : '请输入有效的msn账号(例：abc@hotnail(msn/live).com)'
		},
		startDate:{
			validator : function(value, param){
				var s=$("#"+param[0]).combobox("getValue");
				if(s!= "" && value != ""){
					return s>= value; 
				}else{
					return true;
				}
			},
			message : '开始日期不能大于结束日期！'    
		},
		endDate:{
			validator : function(value, param){
				var s=$("#"+param[0]).combobox("getValue");
				if(s!= "" && value != ""){
					return s<= value; 
				}else{
					return true;
				}
			},
			message : '结束日期不能小于开始日期！'    
		},
		same:{
			validator : function(value, param){
				if($("#"+param[0]).val() != "" && value != ""){
					return $("#"+param[0]).val() == value; 
				}else{
					return true;
				}
			},
			message : '两次输入的密码不一致！'    
		},
		notsame:{
			validator : function(value, param){
				if($("#"+param[0]).val() != "" && value != ""){
					return !($("#"+param[0]).val() == value); 
				}else{
					return true;
				}
			},
			message : '新密码和旧密码一致！'    
		},
		account: {//param的值为[]中值  
	        validator: function (value, param) {  
	            if (value.length < param[0] || value.length > param[1]) {  
	                $.fn.validatebox.defaults.rules.account.message = '用户名长度必须在' + param[0] + '至' + param[1] + '范围';  
	                return false;  
	            } else {  
	                if (!/^[\w]+$/.test(value)) {  
	                    $.fn.validatebox.defaults.rules.account.message = '用户名只能数字、字母、下划线组成.';  
	                    return false;  
	                } else {  
	                    return true;  
	                }  
	            }  
	        }, message: ''
		},
		xiaoshu:{ //校验小数后n位
	        validator : function(value,param){ 
	        	var patern="^(([1-9]{1}[0-9]*)|([0-9]+\.[0-9]{1,"+param[0]+"}))$";
	        	var hh=new RegExp(patern);
	        	if(!hh.test(value)){
	        		 $.fn.validatebox.defaults.rules.xiaoshu.message ="最多保留"+param[0]+"位小数！";
	        	}
	        	return hh.test(value);
	        },
	        message: ''
	    },
	    password:{//密码验证
	    	validator : function(value){ 
	        	var patern=/^(?![0-9]+$)(?![a-zA-Z]+$)\S{6,16}$/;
	        	var hh=new RegExp(patern);
	        	return hh.test(value);
	        },
	        message: '8-16位，不能有空格，纯数字或纯字母'
	    },
	    confirmPass: {
            validator: function(value, param){
                var pass = $(param[0]).passwordbox('getValue');
                return value == pass;
            },
            message: '确认密码与原密码不一致'
        }
	});
}

/**
  * @requires jquery, EasyUI 1.2.6+
  * 
  * 此方法是对 EasyUI.window 和 EasyUI.dialog 的扩展
  * 可以实现如下功能：
  * 1、使用框架页面时可以控制窗口是否跨框架弹出在框架最顶层页面，还是框架内当前页面。默认框架最顶层页面
  * 2、可以控制url加载页面方式，是使用默认方式，还是iframe加载， 默认iframe加载
  * 3、使用iframe加载页面时，可以实现父页面向子页面传递javaScript对象
  * 4、使用iframe加载页面时，可以订制iframe onLoad事件
  * 5、扩展content属性，自动识别是静态文本内容，还是加载页面
  * 6、通过赋值ID属性，控制弹出窗体唯一性
  * 7、toolbar、buttons中定义按钮的handler属性，支持弹出窗体iframe中方法调用。
  * 8、弹出窗体关闭方式更灵活
 
  * 
  * @author zhaojh<zjh527@163.com>
  * @date 2012.11.15
  * 
  */
 (function($){
 	$.namespace('easyui.ext');
 	
 	/**
 	 * 普通窗体
 	 * 
 	 * 新增属性说明如下
 	 * @param isFrame	是否开启使用iframe加载给定url页面, 此属性设置为true时则开启使用iframe加载页面。 值：true|false,  默认值true
 	 * @param self		用于框架页面，如果值为true则不跨框架，否则跨框架弹出在框架最顶层页面。 值:true|false,	默认值false
 	 * @param data		用于在使用iframe加载给定页面时，父页面给子页面传递数据。	默认值null
 	 * 
 	 * 扩展属性说明如下
 	 * @param onLoad	当使用iframe加载给定url页面时，在iframe加载完成后调用。
 	 * 					默认接收一个参数对象，参数对象属性说明参见下面toolbar、buttons说明第2项。
 	 * @param content	可根据内容前缀关键字'url:',来判断是显示静态文本还是加载页面。
 	 * @param id		此属性用来标识弹出窗体的唯一性，不再用来充当panel的id属性
 	 * 
 	 * 特殊属性说明如下
 	 * this.content		iframe方式加载内容页的window对象。 用于onLoad方法中的调用
 	 * 
 	 * 
 	 * toolbar、buttons	属性定义按钮handler属性扩展说明如下
 	 * 1、当handler 被赋值字符串时，表示调用弹出窗体iframe中已有的与字符串值同名的方法,否则调用父里的方法，通过在父和弹出窗口里定义handler来交互数据
 	 * 2、被调用方法默认接收一个参数对象，对象属性如下：
 	 *   data: 类型：Object，是对vseaf.open方法参数data的引用
 	 *   close: 类型：Function，用来关闭弹出窗体
 	 * 
 	 * 
 	 * 
 	 * 
 	 * 注：其他属性请参考EasyUI API文档。
 	 * 
 	 */
 	easyui.ext.open = function(opts){
 		var win=null;
 		var defaults = {
     		minimizable: true,
     		maximizable: true,
     		width:500,
     		height:500,
     		collapsible: true,
     		resizable: true,
     		autoHeight:true,
     		isFrame: true, //是否使用iframe
     		self: false, //用于框架页面，如果值为true则不跨框架，否则跨框架弹出在框架最顶层页面
     		data: null, //iframe方式下用来父页面向弹出窗体中子页面传递数据
     		content: '',
     		onLoad: null,
     		onClose: function(){
     			win.dialog('destroy');
     		}
 		};
 		
 		var options = $.extend({}, defaults, opts);
 		
 		//取顶层页面
 		var _doc, _top = (function(w){
 			try{
 				_doc = w['top'].document;
 				_doc.getElementsByTagName;
 			}catch(e){
 				_doc = w.document; 
 				return w;
 			}
 			
 			if(options.self || _doc.getElementsByTagName('frameset').length >0){
 				_doc = w.document; 
 				return w;
 			}
 			
 			return w['top'];
 		})(window);
 		
 		
 		//如填写ID属性，则窗体唯一
 		var winId=null;
 		if(options.id){
 			winId = options.id;
 			delete options.id;
 			
 			//检查创建窗口是否已经存在，存在则不在创建
 			if($('#'+winId).size()>0){
 				return;
 			}
 		}
 		
 		//检查content内容是静态文本，还是url地址
 		var iframe=null;
 		var isUrl = /^url:/.test(options.content);
 		if(isUrl){
 			var url = options.content.substr(4, options.content.length);
 			//构建iframe加载方式
 			if(options.isFrame){
 				if(options.autoHeight){
 					iframe = $('<iframe ></iframe>')
 	 				
			            .attr('height', '100%')
			            .attr('width', '100%')
			            .attr('marginheight', '0')
			            .attr('marginwidth', '0')
			            .attr('frameborder','0');
 				}else{
 					iframe = $('<iframe ></iframe>')
			            .attr('height', '100%')
			            .attr('width', '100%')
			            .attr('marginheight', '0')
			            .attr('marginwidth', '0')
			            .attr('frameborder','0');
 				}
 				
 				
 				var _this = this;
 				var frameOnLoad = function(){
 					//_this.content = iframe.get(0).contentWindow;
 					var autoSizeFunc=function(){
 						var ch1=$(iframe.get(0)).contents().find("body")[0].scrollHeight;
	 					var ch2=0;
	 					var ch3=$($(iframe.get(0)).contents().find("body")[0]).height();
	 					
	 					ch1=Math.min(ch1,ch3);
	 					if(options.autoHeight){
	 					  //$(iframe.get(0)).contents().find("body").css("overflow","hidden");
	 					}
	 					var titleHeight=win.dialog("header").height()+40;
	 					
	 					var ch= Math.max(ch1, ch2)+titleHeight;
	 					  
	 					if(win){

							win.dialog("resize",{  
								height: ch
							});
							
							win.dialog("center"); 
							
							$(iframe.get(0)).contents().find("body").css("overflow","auto");
							$(iframe.get(0)).contents().find("html").css("overflow","auto");
	 					}else{
	 					 // alert(111);
	 					}
 					};
 					options.onLoad && options.onLoad.call(_this, {
 						data: options.data,
 						window:iframe.get(0).contentWindow,
 						instance:win,
 					
 						autoSize:autoSizeFunc,
 						close: function(){
 							win.dialog('close');
 						}
 					});
 					
 					if(options.autoHeight){
 						autoSizeFunc();
 					}
 				};
 				
 				delete options.content;
 				
 			}else{//使用默认页面加载方式
 				options.href = url;
 			}
 		}
 		
 		//加工toolbar和buttons中定义的handler方法，使其可以接收给定参数，用于iframe方式下的父子页面传值和窗口关闭
 		var warpHandler = function(handler){
 			var args = {data: options.data,close: function(){win.dialog('close');}};
 			
 			/***通过父亲和子窗口里定义的handler，并且通过options.data来传值
 			/**父亲定义的handler***/
 			if(typeof handler =='function'){
 				return function(){
 					handler(args);
 				};
 			}
 			/**子窗口定义的handler**/
 			if(typeof handler == 'string' && options.isFrame){
 				return function(){
 					iframe.get(0).contentWindow[handler](args);
 				};
 			}
 		};
 		
 		//处理toolbar数组事件定义,选择器形式不做处理
 		if(options.toolbar && $.isArray(options.toolbar)){
 			for(var i in options.toolbar){
 				options.toolbar[i].handler = warpHandler(options.toolbar[i].handler);
 			}
 		}
 		
 		//处理buttons数组事件定义,选择器形式不做处理
 		if(options.buttons && $.isArray(options.buttons)){
 			for(var i in options.buttons){
 				options.buttons[i].handler = warpHandler(options.buttons[i].handler);
 			}
 		}
 		
 
 		if(options.isFrame && iframe){
 			
 			win = _top.$('<div  style="overflow:hidden">', {id: winId}).append(iframe).dialog(options);
 			iframe.attr('src', url);
 			iframe.bind('load', frameOnLoad);
 			
			setTimeout(function(){
 				
			}, 50);
 			
 			
 		}else{
 			win = _top.$('<div >', {id: winId}).dialog(options);
 		}
 		return win;
 	}
 	
 	
 	/**
 	 * 
 	 * 模式窗体
 	 * 
 	 * 参数说明请看easyui.ext.open
 	 * 
 	 */
 	easyui.ext.showModalDialog = function(opts){
 		var defaults = $.extend(
 					{}, 
 					opts, 
 					{
 						modal: true, 
 						minimizable: false, 
 						maximizable: false, 
 						resizable: false, 
 						collapsible: false 
 					}
 				);
 		return easyui.ext.open(defaults);
 	};
 	
 	
 	easyui.ext.up=function(tableid){
 		var selections = $('#'+tableid).datagrid("getSelections");
 		//排序
 		selections = $.merge([], selections);;
 		
 		if(selections.length==0){
 			$.messager.alert("提示", "请选择需要排序的记录。",'info');
 			return;
 		}

 		selections.sort(function(x,y){ //升序
 		   var xi=$('#'+tableid).datagrid("getRowIndex",x);
 		   var yi=$('#'+tableid).datagrid("getRowIndex",y);
 		   if (xi>yi){
 		      return 1;
 		   } else if(xi==yi){
 			   return 0;
 		   }else{
 		      return -1;
 		   }
 		 });
 		for(var i=0; i<selections.length; i++){
 			var selIndex=$('#'+tableid).datagrid("getRowIndex",selections[i]);
 			var obj=selections[i];
 			var flag=false;
 			if((selIndex-1)>=0 ){
 				var sels=$('#'+tableid).datagrid("getSelections");
 				for(var n=0; n<sels.length; n++){
 					var index=$('#'+tableid).datagrid("getRowIndex",sels[n]);
 					if(index==selIndex)continue;
 					if(index==selIndex-1) {flag=true;break;};
 				}
 				if(flag) continue;
 				$('#'+tableid).datagrid("deleteRow" ,selIndex);
 				//$('#'+tableid).datagrid("acceptChanges");
 				$('#'+tableid).datagrid("insertRow" ,{
 					index:(selIndex-1),
 					row:obj
 				});
 				//$('#'+tableid).datagrid("acceptChanges");
 				$('#'+tableid).datagrid("selectRow",(selIndex-1));
 			}
 			
 			
 		}
 	};
 	easyui.ext.tobottom=function(tableid){
 		var selections = $('#'+tableid).datagrid("getSelections");
 		//
 		selections = $.merge([], selections);;
 		if(selections.length==0){
 			$.messager.alert("提示", "请选择需要排序的记录。",'info');
 			return;
 		}
 		
 		selections.sort(function(x,y){ //倒序
 			   var xi=$('#'+tableid).datagrid("getRowIndex",x);
 			   var yi=$('#'+tableid).datagrid("getRowIndex",y);
 			   if (xi>yi){
 			      return -1;
 			   } else if(xi==yi){
 				   return 0;
 			   }else{
 			      return 1;
 			   }
 			 });
 		
 		var rowLeng=$('#'+tableid).datagrid("getRows").length;
 		for(var i=0; i<selections.length; i++){
 			var selIndex=$('#'+tableid).datagrid("getRowIndex",selections[i]);
 			if(selIndex >= rowLeng-1-i){
 				continue;
 			}
 			var obj=selections[i];//getRows
 		
 			$('#'+tableid).datagrid("deleteRow" ,selIndex);
 			
 			$('#'+tableid).datagrid("insertRow" ,{
 				index:rowLeng-1-i,
 				row:obj
 			});
 			//$('#'+tableid).datagrid("acceptChanges");
 			$('#'+tableid).datagrid("selectRow",rowLeng-1-i);
 			
 			
 		}
 	};
 	easyui.ext.totop=function(tableid){
 		var selections = $('#'+tableid).datagrid("getSelections");
 		//排序
 		selections = $.merge([], selections);;
 		
 		if(selections.length==0){
 			$.messager.alert("提示", "请选择需要排序的记录。",'info');
 			return;
 		}

 		selections.sort(function(x,y){ //升序
 		   var xi=$('#'+tableid).datagrid("getRowIndex",x);
 		   var yi=$('#'+tableid).datagrid("getRowIndex",y);
 		   if (xi>yi){
 		      return 1;
 		   } else if(xi==yi){
 			   return 0;
 		   }else{
 		      return -1;
 		   }
 		 });
 		for(var i=0; i<selections.length; i++){
 			var selIndex=$('#'+tableid).datagrid("getRowIndex",selections[i]);
 			if(selIndex<=i){
 				continue;
 			}
 			var obj=selections[i];
 			$('#'+tableid).datagrid("deleteRow" ,selIndex);
 			//$('#'+tableid).datagrid("acceptChanges");
 			$('#'+tableid).datagrid("insertRow" ,{
 				index:i,
 				row:obj
 			});
 			//$('#'+tableid).datagrid("acceptChanges");
 			$('#'+tableid).datagrid("selectRow",(i));
 			
 			
 			
 		}
 		
 	};
 	
	easyui.ext.down=function down(tableid){
 		var selections = $('#'+tableid).datagrid("getSelections");
 		//
 		selections = $.merge([], selections);
 		if(selections.length==0){
 			$.messager.alert("提示", "请选择需要排序的记录。",'info');
 			return;
 		}
 		
 		selections.sort(function(x,y){ //倒序
 			   var xi=$('#'+tableid).datagrid("getRowIndex",x);
 			   var yi=$('#'+tableid).datagrid("getRowIndex",y);
 			   if (xi>yi){
 			      return -1;
 			   } else if(xi==yi){
 				   return 0;
 			   }else{
 			      return 1;
 			   }
 			 });
 		
 		var rowLeng=$('#'+tableid).datagrid("getRows").length;
 		for(var i=0; i<selections.length; i++){
 			var selIndex=$('#'+tableid).datagrid("getRowIndex",selections[i]);
 			var obj=selections[i];//getRows
 			var flag=false;
 			if((selIndex+1) < rowLeng ){
 				var sels=$('#'+tableid).datagrid("getSelections");
 				for(var n=0; n<sels.length; n++){
 					var index=$('#'+tableid).datagrid("getRowIndex",sels[n]);
 					
 					if(index==selIndex+1) {flag=true;break;};
 				}
 				if(flag) continue;
 				$('#'+tableid).datagrid("deleteRow" ,selIndex);
 				//$('#'+tableid).datagrid("acceptChanges");
 				$('#'+tableid).datagrid("insertRow" ,{
 					index:(selIndex+1),
 					row:obj
 				});
 				//$('#'+tableid).datagrid("acceptChanges");
 				$('#'+tableid).datagrid("selectRow",(selIndex+1));
 			}
 			
 			
 		}
 	};
 })(jQuery);
 
 function formReset(selector){
	 $(selector)[0].reset();
	 $(selector).form("disableValidation");
	 $(selector).form("enableValidation");
	 $(selector + ' :input').blur();
 }
 
 

 (function($){
	 
	 
	  $.parser.plugins.push("mytextbox");//注册扩展组件
      $.fn.mytextbox = function (options, param) {//定义扩展组件

         //当options为字符串时，说明执行的是该插件的方法。
         if (typeof options == "string") { return $.fn.textbox.apply(this,arguments); }

         //当该组件在一个页面出现多次时，this是一个集合，故需要通过each遍历。
         return  this.each(function () {

             //$.fn.combobox.parseOptions(this)作用是获取页面中的data-options中的配置
             var opts = $.extend({}, $.fn.textbox.parseOptions(this), options);
             //把配置对象myopts放到$.fn.combobox这个函数中执行。
             var myopts = $.extend({}, opts,{ 
            	 //扩展点
             });
             $(this).textbox(myopts);
             
         })
      };
      
      
	  $.parser.plugins.push("mypasswordbox");//注册扩展组件
      $.fn.mypasswordbox = function (options, param) {//定义扩展组件

         //当options为字符串时，说明执行的是该插件的方法。
         if (typeof options == "string") { return $.fn.passwordbox.apply(this,arguments); }

         //当该组件在一个页面出现多次时，this是一个集合，故需要通过each遍历。
         return  this.each(function () {

             //$.fn.combobox.parseOptions(this)作用是获取页面中的data-options中的配置
             var opts = $.extend({}, $.fn.passwordbox.parseOptions(this), options);
             //把配置对象myopts放到$.fn.combobox这个函数中执行。
             var myopts = $.extend({}, opts,{ 
            	 //扩展点
             });
             $(this).passwordbox(myopts);
             
         })
      };

	  $.parser.plugins.push("mycombo");//注册扩展组件
      $.fn.mycombo = function (options, param) {//定义扩展组件

         //当options为字符串时，说明执行的是该插件的方法。
         if (typeof options == "string") { return $.fn.combo.apply(this,arguments); }

         //当该组件在一个页面出现多次时，this是一个集合，故需要通过each遍历。
         return  this.each(function () {

             //$.fn.combobox.parseOptions(this)作用是获取页面中的data-options中的配置
             var opts = $.extend({}, $.fn.combo.parseOptions(this), options);
             //把配置对象myopts放到$.fn.combobox这个函数中执行。
             var myopts = $.extend({}, opts,{ 
            	 //扩展点
             });
             $(this).combo(myopts);
             
         })
      };
      
	  /****************************************************************************
		1.扩展了onSelectByClickItem事件，当用户手动选择combobox下拉选项时触发
		  onSelectByClickItem:function(index, itemRow){}
	  */
	  $.parser.plugins.push("mycombobox");//注册扩展组件

      $.fn.mycombobox = function (options, param) {//定义扩展组件

         //当options为字符串时，说明执行的是该插件的方法。
         if (typeof options == "string") { return $.fn.combobox.apply(this,arguments); }

         //当该组件在一个页面出现多次时，this是一个集合，故需要通过each遍历。
         return  this.each(function () {

             //$.fn.combobox.parseOptions(this)作用是获取页面中的data-options中的配置
             var opts = $.extend({},$.fn.mycombobox.defaults, $.fn.combobox.parseOptions(this), options);

             //把配置对象myopts放到$.fn.combobox这个函数中执行。
             var myopts = $.extend({}, opts,{ 
            	    //扩展点
					// onSelectByClickItem:function(index, itemRow){},  //扩展onSelectByClickItem事件
				     onShowPanel : function(){

						var panel=$(this).combobox("panel");
						var target=this;
						$ (".combobox-item", panel).unbind ('click').click (function (event) {
								var sindex = $(this).attr('id').lastIndexOf('_');
								var index = $(this).attr('id').substr(sindex + 1,$(this).attr('id').length - sindex - 1);
								var data = $(target).combobox ("getData");
								var itemRow=data[index];
								if(opts.onSelectByClickItem){
									opts.onSelectByClickItem.call(target, index,itemRow)
								}
								
						});
						if(opts.onShowPanel){
							var ret=opts.onShowPanel.call(this);
						}

					 }//onShowPannel
             });
             $(this).combobox(myopts);
             
         })
      };  
	
      $.fn.mycombobox.defaults = $.extend({}, {
		   onSelectByClickItem:function(index, itemRow){} //扩展onSelectByClickItem事件	
	  });
      
	  /***********************************************************************/
	  $.parser.plugins.push("mycombotree");//注册扩展组件
      $.fn.mycombotree = function (options, param) {//定义扩展组件

         //当options为字符串时，说明执行的是该插件的方法。
         if (typeof options == "string") { return $.fn.combotree.apply(this,arguments); }

         //当该组件在一个页面出现多次时，this是一个集合，故需要通过each遍历。
         return  this.each(function () {

             //$.fn.combobox.parseOptions(this)作用是获取页面中的data-options中的配置
             var opts = $.extend({}, $.fn.combotree.parseOptions(this), options);
             //把配置对象myopts放到$.fn.combobox这个函数中执行。
             var myopts = $.extend({}, opts,{ 
            	 //扩展点
             });
             $(this).combotree(myopts);
             
         })
      };
	  $.parser.plugins.push("mycombogrid");//注册扩展组件
      $.fn.mycombogrid = function (options, param) {//定义扩展组件

         //当options为字符串时，说明执行的是该插件的方法。
         if (typeof options == "string") { return $.fn.combogrid.apply(this,arguments); }

         //当该组件在一个页面出现多次时，this是一个集合，故需要通过each遍历。
         return  this.each(function () {

             //$.fn.combobox.parseOptions(this)作用是获取页面中的data-options中的配置
             var opts = $.extend({}, $.fn.combogrid.parseOptions(this), options);
             //把配置对象myopts放到$.fn.combobox这个函数中执行。
             var myopts = $.extend({}, opts,{ 
            	 //扩展点
             });
             $(this).combogrid(myopts);
             
         })
      };
      
      
	  $.parser.plugins.push("mycombotreegrid");//注册扩展组件
      $.fn.mycombotreegrid = function (options, param) {//定义扩展组件

         //当options为字符串时，说明执行的是该插件的方法。
         if (typeof options == "string") { return $.fn.combotreegrid.apply(this,arguments); }

         //当该组件在一个页面出现多次时，this是一个集合，故需要通过each遍历。
         return  this.each(function () {

             //$.fn.combobox.parseOptions(this)作用是获取页面中的data-options中的配置
             var opts = $.extend({}, $.fn.combotreegrid.parseOptions(this), options);
             //把配置对象myopts放到$.fn.combobox这个函数中执行。
             var myopts = $.extend({}, opts,{ 
            	 //扩展点
             });
             $(this).combotreegrid(myopts);
             
         })
      };
      
	  $.parser.plugins.push("mynumberbox");//注册扩展组件
      $.fn.mynumberbox = function (options, param) {//定义扩展组件

         //当options为字符串时，说明执行的是该插件的方法。
         if (typeof options == "string") { return $.fn.numberbox.apply(this,arguments); }

         //当该组件在一个页面出现多次时，this是一个集合，故需要通过each遍历。
         return  this.each(function () {

             //$.fn.combobox.parseOptions(this)作用是获取页面中的data-options中的配置
             var opts = $.extend({}, $.fn.numberbox.parseOptions(this), options);
             //把配置对象myopts放到$.fn.combobox这个函数中执行。
             var myopts = $.extend({}, opts,{ 
            	 //扩展点
             });
             $(this).numberbox(myopts);
             
         })
      };
      
      
	  $.parser.plugins.push("mydatebox");//注册扩展组件
      $.fn.mydatebox = function (options, param) {//定义扩展组件

         //当options为字符串时，说明执行的是该插件的方法。
         if (typeof options == "string") { return $.fn.datebox.apply(this,arguments); }

         //当该组件在一个页面出现多次时，this是一个集合，故需要通过each遍历。
         return  this.each(function () {

             //$.fn.combobox.parseOptions(this)作用是获取页面中的data-options中的配置
             var opts = $.extend({}, $.fn.datebox.parseOptions(this), options);
             //把配置对象myopts放到$.fn.combobox这个函数中执行。
             var myopts = $.extend({}, opts,{ 
            	 //扩展点
             });
             $(this).datebox(myopts);
             
             if(myopts.displayRealTime){
            	 var that=this;
            	 $(that).datebox("setValue",new Date().format());
            	 setInterval(function(){
            		 $(that).datebox("setValue",new Date().format());
            	 },1000); 
             }
             
         })
      };
      
	  $.parser.plugins.push("mydatetimebox");//注册扩展组件
	  /****
	   扩展属性：
	   displayRealTime:显示当前实时日期时间
	   */
      $.fn.mydatetimebox = function (options, param) {//定义扩展组件

         //当options为字符串时，说明执行的是该插件的方法。
         if (typeof options == "string") { return $.fn.datetimebox.apply(this,arguments); }

         //当该组件在一个页面出现多次时，this是一个集合，故需要通过each遍历。
         return  this.each(function () {

             //$.fn.combobox.parseOptions(this)作用是获取页面中的data-options中的配置
             var opts = $.extend({}, $.fn.datetimebox.parseOptions(this), options);
             //把配置对象myopts放到$.fn.combobox这个函数中执行。
             var myopts = $.extend({}, opts,{ 
            	 //扩展点
             });
             
             $(this).datetimebox(myopts);
             if(myopts.displayRealTime){
            	 var that=this;
            	 $(that).datetimebox("setValue",new Date().format());
            	 setInterval(function(){
            		 $(that).datetimebox("setValue",new Date().format());
            	 },1000); 
             }
             
         })
      };
      
      $.parser.plugins.push("mydatetimespinner");//注册扩展组件
      $.fn.mydatetimespinner = function (options, param) {//定义扩展组件

         //当options为字符串时，说明执行的是该插件的方法。
         if (typeof options == "string") { return $.fn.datetimespinner.apply(this,arguments); }

         //当该组件在一个页面出现多次时，this是一个集合，故需要通过each遍历。
         return  this.each(function () {

             //$.fn.combobox.parseOptions(this)作用是获取页面中的data-options中的配置
             var opts = $.extend({}, $.fn.datetimespinner.parseOptions(this), options);
             //把配置对象myopts放到$.fn.combobox这个函数中执行。
             var myopts = $.extend({}, opts,{ 
            	 //扩展点
             });
             $(this).datetimespinner(myopts);
             
         })
      };
      
      $.parser.plugins.push("mycalendar");//注册扩展组件
      $.fn.mycalendar = function (options, param) {//定义扩展组件

         //当options为字符串时，说明执行的是该插件的方法。
         if (typeof options == "string") { return $.fn.calendar.apply(this,arguments); }

         //当该组件在一个页面出现多次时，this是一个集合，故需要通过each遍历。
         return  this.each(function () {

             //$.fn.combobox.parseOptions(this)作用是获取页面中的data-options中的配置
             var opts = $.extend({}, $.fn.calendar.parseOptions(this), options);
             //把配置对象myopts放到$.fn.combobox这个函数中执行。
             var myopts = $.extend({}, opts,{ 
            	 //扩展点
             });
             $(this).calendar(myopts);
             
         })
      };
      
     // $.parser.plugins.push("myspinner");//注册扩展组件
      $.fn.myspinner = function (options, param) {//定义扩展组件

         //当options为字符串时，说明执行的是该插件的方法。
         if (typeof options == "string") { return $.fn.spinner.apply(this,arguments); }

         //当该组件在一个页面出现多次时，this是一个集合，故需要通过each遍历。
         return  this.each(function () {

             //$.fn.combobox.parseOptions(this)作用是获取页面中的data-options中的配置
             var opts = $.extend({}, $.fn.spinner.parseOptions(this), options);
             //把配置对象myopts放到$.fn.combobox这个函数中执行。
             var myopts = $.extend({}, opts,{ 
            	 //扩展点
             });
             $(this).spinner(myopts);
             
         })
      };
      
      $.parser.plugins.push("mynumberspinner");//注册扩展组件
      $.fn.mynumberspinner = function (options, param) {//定义扩展组件

         //当options为字符串时，说明执行的是该插件的方法。
         if (typeof options == "string") { return $.fn.numberspinner.apply(this,arguments); }

         //当该组件在一个页面出现多次时，this是一个集合，故需要通过each遍历。
         return  this.each(function () {

             //$.fn.combobox.parseOptions(this)作用是获取页面中的data-options中的配置
             var opts = $.extend({}, $.fn.numberspinner.parseOptions(this), options);
             //把配置对象myopts放到$.fn.combobox这个函数中执行。
             var myopts = $.extend({}, opts,{ 
            	 //扩展点
             });
             $(this).numberspinner(myopts);
             
         })
      };
      
      $.parser.plugins.push("mytimespinner");//注册扩展组件
      $.fn.mytimespinner = function (options, param) {//定义扩展组件

         //当options为字符串时，说明执行的是该插件的方法。
         if (typeof options == "string") { return $.fn.timespinner.apply(this,arguments); }

         //当该组件在一个页面出现多次时，this是一个集合，故需要通过each遍历。
         return  this.each(function () {

             //$.fn.combobox.parseOptions(this)作用是获取页面中的data-options中的配置
             var opts = $.extend({}, $.fn.timespinner.parseOptions(this), options);
             //把配置对象myopts放到$.fn.combobox这个函数中执行。
             var myopts = $.extend({}, opts,{ 
            	 //扩展点
             });
             $(this).timespinner(myopts);
             
         })
      };
      
      $.parser.plugins.push("myslider");//注册扩展组件
      $.fn.myslider = function (options, param) {//定义扩展组件

         //当options为字符串时，说明执行的是该插件的方法。
         if (typeof options == "string") { return $.fn.slider.apply(this,arguments); }

         //当该组件在一个页面出现多次时，this是一个集合，故需要通过each遍历。
         return  this.each(function () {

             //$.fn.combobox.parseOptions(this)作用是获取页面中的data-options中的配置
             var opts = $.extend({}, $.fn.slider.parseOptions(this), options);
             //把配置对象myopts放到$.fn.combobox这个函数中执行。
             var myopts = $.extend({}, opts,{ 
            	 //扩展点
             });
             $(this).slider(myopts);
             
         })
      };
      
      $.parser.plugins.push("myfilebox");//注册扩展组件
      $.fn.myfilebox = function (options, param) {//定义扩展组件

         //当options为字符串时，说明执行的是该插件的方法。
         if (typeof options == "string") { return $.fn.filebox.apply(this,arguments); }

         //当该组件在一个页面出现多次时，this是一个集合，故需要通过each遍历。
         return  this.each(function () {

             //$.fn.combobox.parseOptions(this)作用是获取页面中的data-options中的配置
             var opts = $.extend({}, $.fn.filebox.parseOptions(this), options);
             //把配置对象myopts放到$.fn.combobox这个函数中执行。
             var myopts = $.extend({}, opts,{ 
            	 //扩展点
             });
             $(this).filebox(myopts);
             
         })
      };
      
      $.parser.plugins.push("mywindow");//注册扩展组件
      $.fn.mywindow = function (options, param) {//定义扩展组件

         //当options为字符串时，说明执行的是该插件的方法。
         if (typeof options == "string") { return $.fn.window.apply(this,arguments); }

         //当该组件在一个页面出现多次时，this是一个集合，故需要通过each遍历。
         return  this.each(function () {

             //$.fn.combobox.parseOptions(this)作用是获取页面中的data-options中的配置
             var opts = $.extend({}, $.fn.window.parseOptions(this), options);
             //把配置对象myopts放到$.fn.combobox这个函数中执行。
             var myopts = $.extend({}, opts,{ 
            	 //扩展点
             });
             $(this).window(myopts);
             
         })
      };
      
      $.parser.plugins.push("mydialog");//注册扩展组件
      $.fn.mydialog = function (options, param) {//定义扩展组件

         //当options为字符串时，说明执行的是该插件的方法。
         if (typeof options == "string") { return $.fn.dialog.apply(this,arguments); }

         //当该组件在一个页面出现多次时，this是一个集合，故需要通过each遍历。
         return  this.each(function () {

             //$.fn.combobox.parseOptions(this)作用是获取页面中的data-options中的配置
             var opts = $.extend({}, $.fn.dialog.parseOptions(this), options);
             //把配置对象myopts放到$.fn.combobox这个函数中执行。
             var myopts = $.extend({}, opts,{ 
            	 //扩展点
             });
             $(this).dialog(myopts);
             
         })
      };
      
      /**
       * 
       * 1: 扩展了highlightRowLikeSelect(rowindex)方法：高亮某行，效果和select某行的效果相似，只是没有真实选择效果
       * 3：field里有redStar:true的，则对应的表头文字前有红色*
       * 4: 添加onOutCellClick(editCellsInfo,srcdom)事件，当用户点击表格数据外的区域触发，editCellsInfo 为：[{'rowIndex':1,'fields':['userName','sex']},..]
	   * 5：扩展方法acceptChange(uuid,type)，提交指定行的改变,uuid：所提交某行的uuid
	   * 6:扩展方法clearSelection(rowindex)，和highlightRowLikeSelect相反的效果，取消高亮某行
	   * 7:扩展方法：getEditCells() ,扩展方法：getEditCells() ,获得当前所有的编辑cell的索引，返回数组，例如[{'rowIndex':1,'fields':['userName','sex']},..]
	   * 8:扩展方法：getEditRows()，获得当前所有正在编辑的行号数组
	   * 9:扩展方法：updateCell(rowIndex,field,val) ,可以在不用刷新的情况下更新某个单元格
	   * 10:扩展方法：isSelection(rowIndex)，判断指定的行是否选中
	   * 11:扩展方法:isChecked(rowIndex)，判断指定的行是否已经选择
       */
      $.parser.plugins.push("mydatagrid");//注册扩展组件
      $.fn.mydatagrid = function (options, param) {//定义扩展组件

		  
    	  function isNullObj (value) {
    			return value == null || value == undefined || value.length == 0 || value == 'null';
    		}
		  function addRedStars ($table) {
				var array = [];
				var opt = $table.datagrid ('options').columns;
				if(opt && opt[0] && opt[0].length){
					for (var i = 0; i < opt[0].length; i++){
						if (!isNullObj (opt[0][i].redStar)){
							array.push (opt[0][i].field);
						}
					}
				}
				
				var dom = $table.datagrid ("getPanel").find ('.datagrid-header-row .datagrid-cell span:first-child').each (
				        function () {
					        if (array.indexOf ($ (this).parent ().parent ().attr ('field')) > -1)
						        $ (this).before ("<span style='color:red'>*</span>");
				 });
		 }
         //当options为字符串时，说明执行的是该插件的方法。
        // if (typeof options == "string") { return $.fn.datagrid.apply(this,arguments); }
		 if (typeof options == 'string'){
			var method = $.fn.mydatagrid.methods[options];
			if (method){
				 var args = Array.prototype.slice.call(arguments); 
				 args[0]=this;
				 //alert($.toJSON(args));
				 return method.apply(this, args);
			} else {
				return $.fn.datagrid.apply(this,arguments);
			}
		}

         //当该组件在一个页面出现多次时，this是一个集合，故需要通过each遍历。
         return  this.each(function () {

             //$.fn.combobox.parseOptions(this)作用是获取页面中的data-options中的配置
             var opts = $.extend({}, $.fn.datagrid.parseOptions(this), options);
             //把配置对象myopts放到$.fn.combobox这个函数中执行。
             var myopts = $.extend({}, opts,{ 
				 /**
				 扩展事件，当用户点击表格数据外的区域触发
				 editCellsInfo: 为数组，例如[{'rowIndex':1,'fields':['userName','sex']},{'rowIndex':2,'fields':['sex']},..]
				 srcdom：当前点击的dom对象
				 */
 				onOutCellClick:function(editCellsInfo,srcdom){},
 				onClickRow:function(index,row){
					$(this).mydatagrid ("uncheckAll");
 	 				$(this).mydatagrid ("checkRow",index);
 	 				$(this).mydatagrid ("highlightRowLikeSelect",index);
 					if(opts.onClickRow){
 						var ret=opts.onClickRow.call(this,index,row);
 					}
 				},
 				onCheck:function(index,row){
					$(this).mydatagrid ("highlightRowLikeSelect",index);
 					if(opts.onCheck){
 						var ret=opts.onCheck.call(this,index,row);
 					}
 					
 				},
				onBeforeEdit:function(index,row){
					 if(opts.onBeforeEdit){
						var ret=opts.onBeforeEdit.call(this,index,row);
					}
				 },
				 loadFilter:function(data){
					if(data && data.rows && data.rows.length){
						//alert($.toJSON(data));
						$.each(data.rows,function(index,e){
							e.uuid=myuuid(10,10);
						});
						
					}
					if(opts.loadFilter){
						var ret=opts.loadFilter.call(this,data);
						return ret;
					}else{
						return data;
					}
					
				}

             });

             $(this).datagrid(myopts);
              addRedStars($(this));
			 var panel=$(this).datagrid('getPanel');

			 var target=this;

			$("body").on('click',function(e){
				if($(e.target).is(":input")||$(e.target).closest("a,.window").length){
					return;
				}
				//display: block;
				if($(".window:visible").length){
					return;
				}

				var jtable=$(panel).find('.datagrid-body .datagrid-btable');
				var ret=$(e.target).closest('.datagrid-btable tr,td');
				if(ret.length){
					//
				}else{
					
					var cells=$(target).mydatagrid("getEditCells");//数组,元素为对象。[{'rowIndex':1,'fields':['userName','sex']},..]
					if(opts.onOutCellClick && cells.length>0){
						//alert(33333);
						opts.onOutCellClick.call(target,cells,e.target);
					}
					

				}
			});

             
         })//each
      };//mydatagrid define
	
	 $.fn.mydatagrid.methods = {
		/**highlightRowLikeSelect方法：高亮某行，效果和选择某行效果相似，只是不会触发选择事件
		   index:行号
		 */
		highlightRowLikeSelect: function(jq, index){
			return jq.each(function(){
				var panel=$(this).datagrid("getPanel");
				panel.find('.datagrid-body tr[datagrid-row-index="'+index+'"]').addClass("datagrid-row-selected");

			});
		},
		isSelection:function(jq,index){
			var rows=$(jq).datagrid("getSelections");
			if(rows && rows.length>0){
				for(var i=0;i<rows.length; i++){
					var rowindex=$(jq).datagrid("getRowIndex",rows[i]);
					if(index==rowindex){
						return true;
					}
				}
			}
			return false;
		},
		isChecked:function(jq,index){
			var rows=$(jq).datagrid("getChecked");
			if(rows && rows.length>0){
				for(var i=0;i<rows.length; i++){
					var rowindex=$(jq).datagrid("getRowIndex",rows[i]);
					if(index==rowindex){
						return true;
					}
				}
			}
			return false;
		},
		/**
		 * 重写clearChecked方法，解决原clearChecked方法的bug
		 */
		clearChecked:function(jq){
			var ret=$(jq).datagrid('clearChecked');
			var panel=$(jq).datagrid("getPanel");
			panel.find("div.datagrid-cell-check input[type=checkbox]").attr("checked",false);
			return ret;
		},
		/**
		  扩展方法clearSelection，和highlightRowLikeSelect相反的效果，取消高亮某行
		  index：行号
		*/
		clearSelection:function(jq,index){
			return jq.each(function(){
				var panel=$(this).datagrid("getPanel");
				panel.find('.datagrid-body tr[datagrid-row-index="'+index+'"]').removeClass("datagrid-row-selected");
		
			});
		},
		/**
		  扩展方法：getEditCells() ,获得当前所有的编辑cell的索引，返回数组，数组元素为对象{'rowIndex':1,'fields':['userName','sex']}
		*/

		getEditCells:function(jq){
				var obj=[];
				var panel=$(this).datagrid("getPanel");
				var eds=$(panel).find('.datagrid-body .datagrid-editable').each(function(){
						var editcell=$(this).closest("td[field]"); //field="attr1"
						var field=editcell.attr("field");
						var rowIndex=$(this).closest(".datagrid-body tr[datagrid-row-index]").attr("datagrid-row-index")-0;
						var find=false;
						for(var i=0;i<obj.length ;i++ )
						{
							var e=obj[i];
							if(e.rowIndex==rowIndex){
							   obj.push({'rowIndex':rowIndex,'fields':e.fields.push(field)});
							   find=true;
							}
						}
						if(!find){
							 obj.push({'rowIndex':rowIndex,'fields':[field]});
						}
						
					});
				return obj;
			
			//
		},
		/**
		  扩展方法：getEditRows()，获得当前所有正在编辑的行号,返回数组包含行索引
		*/
		getEditRows:function(jq){
			var obj=[];
			var panel=$(this).datagrid("getPanel");
			var eds=$(panel).find('.datagrid-body .datagrid-editable').each(function(){
				var rowIndex=$(this).closest(".datagrid-body tr[datagrid-row-index]").attr("datagrid-row-index")-0;
				if(obj.indexOf(rowIndex)<0){
					obj.push(rowIndex);
				}
			});
			return obj;
		},
		/**扩展方法：updateCell(rowIndex,field,val) ,可以在不用刷新的情况下更新某个单元格
		*/
		updateCell:function(jq,rowIndex,field,val){

			return jq.each(function(){
				var panel=$(this).datagrid("getPanel");
				$(panel).find('.datagrid-body tr[datagrid-row-index="'+rowIndex+'"] td[field="'+field+'"] div.datagrid-cell').html(val);
				var rows=$(this).datagrid('getRows');
				var row=rows[rowIndex];
				row[field]=val;
				//改变update change数组
				var  upds=$.data(this,"datagrid").updatedRows;
				var find=false;
				for(var i=0; i<upds.length; i++){
					if(upds[i].uuid==row.uuid){
						find=true;
						break;
					}
				}
				if(!find){
					upds.push(row);
				}
				
				//alert('row='+$.toJSON(row)+",value="+val+',field='+field);

			});

		},
		appendRow:function(jq,row){
			row.uuid=myuuid(10,10);
			return $(jq).datagrid('appendRow',row);
		},
		insertRow:function(jq,param){
			param.row.uuid=myuuid(10,10);
			return $(jq).datagrid('insertRow',param);
		},
		
		/**
			扩展方法：acceptChange，提交指定行的改变
			uuid：所提交某行的uuid。如果是数字，表明是行号。insert和upate可以用行号，但delete必须用uuid
			type: inserted,deleted,updated，如果不赋值，则在所有类型（增删改）改变的行里查找rowIndex，并提交。
		*/
		acceptChange:function(jq,uuid,type){

			return jq.each(function(){
				var ins=$.data(this,"datagrid").insertedRows;
				var  dels=$.data(this,"datagrid").deletedRows;
				var  upds=$.data(this,"datagrid").updatedRows;
				var  orgs=$.data(this,"datagrid").originalRows;
				var _this=this;

				//如果 uuid参数传过来的为数字，表明是行号
				if(typeof(uuid)=='number'){
					var rows=$(this).datagrid("getRows");
					uuid=rows[uuid-0].uuid;
				}
				

				function doAccept(changeRowsArray,arrayIndex,uuid,dgridEl,type){

					//删除原始数组里的相应值
					if(orgs.length){
						for(var i=0; i<orgs.length; i++){
							if(orgs[i].uuid==uuid){
								orgs.splice(i,1);
								break;
							}
							
						}
					}
					if(type=='inserted' || type=='updated'){
						var rowIndex=-1;
						var rows=$(dgridEl).datagrid("getRows");
						if(rows.length){
							for(var n=0;n<rows.length; n++){
								if(rows[n].uuid==uuid){
									//alert(n);
									rowIndex=n;
								}
							}
						}
						if(rowIndex>=0&& validateRow(dgridEl,rowIndex)){
							orgs.push(changeRowsArray[arrayIndex]);
							$(_this).mydatagrid("endEdit",rowIndex);
						}
								
					}else{ // deleted

					}
			
					//changeRowsArray.splice(arrayIndex,1);//删除
					for(var i=0; i<ins.length; i++){
						if(ins[i].uuid==uuid){
							ins.splice(i,1);//删除
							i--;
						}
					}
					for(var i=0; i<dels.length; i++){
						if(dels[i].uuid==uuid){
							dels.splice(i,1);//删除
							i--;
						}
					}
					for(var i=0; i<upds.length; i++){
						if(upds[i].uuid==uuid){
							upds.splice(i,1);//删除
							i--;
						}
					}
					
					
				}

				function validateRow(dgridEl,index){
					var tr=$.data(dgridEl,"datagrid").options.finder.getTr(dgridEl,index);
					if(!tr.hasClass("datagrid-row-editing")){
						return true;
					}
					var vbox=tr.find(".validatebox-text");
					vbox.validatebox("validate");
					vbox.trigger("mouseleave");
					var invalbox=tr.find(".validatebox-invalid");
					return invalbox.length==0;
				};
				if(!type){
					for(var i=0; i<ins.length; i++){
						if(ins[i].uuid==uuid){
								doAccept(ins,i,uuid,this,'inserted');
								return;
							}
					}
					
					for(var i=0; i<upds.length; i++){
						if(upds[i].uuid==uuid){
							doAccept(upds,i,uuid,this,'updated');
							return;
						}
					}

					for(var i=0; i<dels.length; i++){
						if(dels[i].uuid==uuid){
							doAccept(dels,i,uuid,this,'deleted');
							return;
						}
					}
				}else{
					if(type=='inserted'){
						for(var i=0; i<ins.length; i++){
							if(ins[i].uuid==uuid){
								doAccept(ins,i,uuid,this,'inserted');
								return;
							}
						}
					}
					if(type=='updated'){
						for(var i=0; i<upds.length; i++){
							if(upds[i].uuid==uuid){
								doAccept(upds,i,uuid,this,'updated');
								return;
							}
						}
					}

					if(type=='deleted'){
						for(var i=0; i<dels.length; i++){
							if(dels[i].uuid==uuid){
								doAccept(dels,i,uuid,this,'deleted');
								return;
							}
						}
					}
				}

			});
		
		}


	 };
	  //////////////////////////////////////////////////
      $.parser.plugins.push("mydatalist");//注册扩展组件
      $.fn.mydatalist  = function (options, param) {//定义扩展组件

         //当options为字符串时，说明执行的是该插件的方法。
         if (typeof options == "string") { return $.fn.datalist.apply(this,arguments); }

         //当该组件在一个页面出现多次时，this是一个集合，故需要通过each遍历。
         return  this.each(function () {

             //$.fn.combobox.parseOptions(this)作用是获取页面中的data-options中的配置
             var opts = $.extend({}, $.fn.datalist.parseOptions(this), options);
             //把配置对象myopts放到$.fn.combobox这个函数中执行。
             var myopts = $.extend({}, opts,{ 
            	 //扩展点
             });
             $(this).datalist(myopts);
             
         })
      };
      
      $.parser.plugins.push("mypropertygrid");//注册扩展组件
      $.fn.mypropertygrid = function (options, param) {//定义扩展组件

         //当options为字符串时，说明执行的是该插件的方法。
         if (typeof options == "string") { return $.fn.propertygrid.apply(this,arguments); }

         //当该组件在一个页面出现多次时，this是一个集合，故需要通过each遍历。
         return  this.each(function () {

             //$.fn.combobox.parseOptions(this)作用是获取页面中的data-options中的配置
             var opts = $.extend({}, $.fn.propertygrid.parseOptions(this), options);
             //把配置对象myopts放到$.fn.combobox这个函数中执行。
             var myopts = $.extend({}, opts,{ 
            	 //扩展点
             });
             $(this).propertygrid(myopts);
             
         })
      };
      
      $.parser.plugins.push("mytree");//注册扩展组件
      $.fn.mytree = function (options, param) {//定义扩展组件

         //当options为字符串时，说明执行的是该插件的方法。
         if (typeof options == "string") { return $.fn.tree.apply(this,arguments); }

         //当该组件在一个页面出现多次时，this是一个集合，故需要通过each遍历。
         return  this.each(function () {

             //$.fn.combobox.parseOptions(this)作用是获取页面中的data-options中的配置
             var opts = $.extend({}, $.fn.tree.parseOptions(this), options);
             //把配置对象myopts放到$.fn.combobox这个函数中执行。
             var myopts = $.extend({}, opts,{ 
            	 //扩展点
             });
             $(this).tree(myopts);
             
         })
      };
      
      $.parser.plugins.push("mytreegrid");//注册扩展组件
      $.fn.mytreegrid = function (options, param) {//定义扩展组件

         //当options为字符串时，说明执行的是该插件的方法。
         if (typeof options == "string") { return $.fn.treegrid.apply(this,arguments); }

         //当该组件在一个页面出现多次时，this是一个集合，故需要通过each遍历。
         return  this.each(function () {

             //$.fn.combobox.parseOptions(this)作用是获取页面中的data-options中的配置
             var opts = $.extend({}, $.fn.treegrid.parseOptions(this), options);
             //把配置对象myopts放到$.fn.combobox这个函数中执行。
             var myopts = $.extend({}, opts,{ 
            	 //扩展点
             });
             $(this).treegrid(myopts);
             
         })
      };
      
      
      $.parser.plugins.push("myvalidatebox");//注册扩展组件
      $.fn.myvalidatebox = function (options, param) {//定义扩展组件

         //当options为字符串时，说明执行的是该插件的方法。
         if (typeof options == "string") { return $.fn.validatebox.apply(this,arguments); }

         //当该组件在一个页面出现多次时，this是一个集合，故需要通过each遍历。
         return  this.each(function () {

             //$.fn.combobox.parseOptions(this)作用是获取页面中的data-options中的配置
             var opts = $.extend({}, $.fn.validatebox.parseOptions(this), options);
             //把配置对象myopts放到$.fn.combobox这个函数中执行。
             var myopts = $.extend({}, opts,{ 
            	 //扩展点
             });
             $(this).validatebox(myopts);
             
         })
      };
      
      
      $.parser.plugins.push("myswitchbutton");//注册扩展组件
      $.fn.myswitchbutton = function (options, param) {//定义扩展组件

         //当options为字符串时，说明执行的是该插件的方法。
         if (typeof options == "string") { return $.fn.switchbutton.apply(this,arguments); }

         //当该组件在一个页面出现多次时，this是一个集合，故需要通过each遍历。
         return  this.each(function () {

             //$.fn.combobox.parseOptions(this)作用是获取页面中的data-options中的配置
             var opts = $.extend({}, $.fn.switchbutton.parseOptions(this), options);
             //把配置对象myopts放到$.fn.combobox这个函数中执行。
             var myopts = $.extend({}, opts,{ 
            	 //扩展点
             });
             $(this).switchbutton(myopts);
             
         })
      };
      
      $.parser.plugins.push("mysplitbutton");//注册扩展组件
      $.fn.mysplitbutton = function (options, param) {//定义扩展组件

         //当options为字符串时，说明执行的是该插件的方法。
         if (typeof options == "string") { return $.fn.splitbutton.apply(this,arguments); }

         //当该组件在一个页面出现多次时，this是一个集合，故需要通过each遍历。
         return  this.each(function () {

             //$.fn.combobox.parseOptions(this)作用是获取页面中的data-options中的配置
             var opts = $.extend({}, $.fn.splitbutton.parseOptions(this), options);
             //把配置对象myopts放到$.fn.combobox这个函数中执行。
             var myopts = $.extend({}, opts,{ 
            	 //扩展点
             });
             $(this).splitbutton(myopts);
             
         })
      };
      
      $.parser.plugins.push("mymenubutton");//注册扩展组件
      $.fn.mymenubutton = function (options, param) {//定义扩展组件

         //当options为字符串时，说明执行的是该插件的方法。
         if (typeof options == "string") { return $.fn.menubutton.apply(this,arguments); }

         //当该组件在一个页面出现多次时，this是一个集合，故需要通过each遍历。
         return  this.each(function () {

             //$.fn.combobox.parseOptions(this)作用是获取页面中的data-options中的配置
             var opts = $.extend({}, $.fn.menubutton.parseOptions(this), options);
             //把配置对象myopts放到$.fn.combobox这个函数中执行。
             var myopts = $.extend({}, opts,{ 
            	 //扩展点
             });
             $(this).menubutton(myopts);
             
         })
      };
      
      $.parser.plugins.push("mylinkbutton");//注册扩展组件
      $.fn.mylinkbutton = function (options, param) {//定义扩展组件

         //当options为字符串时，说明执行的是该插件的方法。
         if (typeof options == "string") { return $.fn.linkbutton.apply(this,arguments); }

         //当该组件在一个页面出现多次时，this是一个集合，故需要通过each遍历。
         return  this.each(function () {

             //$.fn.combobox.parseOptions(this)作用是获取页面中的data-options中的配置
             var opts = $.extend({}, $.fn.linkbutton.parseOptions(this), options);
             //把配置对象myopts放到$.fn.combobox这个函数中执行。
             var myopts = $.extend({}, opts,{ 
            	 //扩展点
             });
             $(this).linkbutton(myopts);
             
         })
      };
      
      $.parser.plugins.push("mymenu");//注册扩展组件
      $.fn.mymenu = function (options, param) {//定义扩展组件

         //当options为字符串时，说明执行的是该插件的方法。
         if (typeof options == "string") { return $.fn.menu.apply(this,arguments); }

         //当该组件在一个页面出现多次时，this是一个集合，故需要通过each遍历。
         return  this.each(function () {

             //$.fn.combobox.parseOptions(this)作用是获取页面中的data-options中的配置
             var opts = $.extend({}, $.fn.menu.parseOptions(this), options);
             //把配置对象myopts放到$.fn.combobox这个函数中执行。
             var myopts = $.extend({}, opts,{ 
            	 //扩展点
             });
             $(this).menu(myopts);
             
         })
      };
      
      $.parser.plugins.push("mylayout");//注册扩展组件
      $.fn.mylayout = function (options, param) {//定义扩展组件

         //当options为字符串时，说明执行的是该插件的方法。
         if (typeof options == "string") { return $.fn.layout.apply(this,arguments); }

         //当该组件在一个页面出现多次时，this是一个集合，故需要通过each遍历。
         return  this.each(function () {

             //$.fn.combobox.parseOptions(this)作用是获取页面中的data-options中的配置
             var opts = $.extend({}, $.fn.layout.parseOptions(this), options);
             //把配置对象myopts放到$.fn.combobox这个函数中执行。
             var myopts = $.extend({}, opts,{ 
            	 //扩展点
             });
             $(this).layout(myopts);
             
         })
      };
      
      $.parser.plugins.push("myaccordion");//注册扩展组件
      $.fn.myaccordion = function (options, param) {//定义扩展组件

         //当options为字符串时，说明执行的是该插件的方法。
         if (typeof options == "string") { return $.fn.accordion.apply(this,arguments); }

         //当该组件在一个页面出现多次时，this是一个集合，故需要通过each遍历。
         return  this.each(function () {

             //$.fn.combobox.parseOptions(this)作用是获取页面中的data-options中的配置
             var opts = $.extend({}, $.fn.accordion.parseOptions(this), options);
             //把配置对象myopts放到$.fn.combobox这个函数中执行。
             var myopts = $.extend({}, opts,{ 
            	 //扩展点
             });
             $(this).accordion(myopts);
             
         })
      };
      
      $.parser.plugins.push("mytabs");//注册扩展组件
      $.fn.mytabs = function (options, param) {//定义扩展组件

         //当options为字符串时，说明执行的是该插件的方法。
         if (typeof options == "string") { return $.fn.tabs.apply(this,arguments); }

         //当该组件在一个页面出现多次时，this是一个集合，故需要通过each遍历。
         return  this.each(function () {

             //$.fn.combobox.parseOptions(this)作用是获取页面中的data-options中的配置
             var opts = $.extend({}, $.fn.tabs.parseOptions(this), options);
             //把配置对象myopts放到$.fn.combobox这个函数中执行。
             var myopts = $.extend({}, opts,{ 
            	 //扩展点
             });
             $(this).tabs(myopts);
             
         })
      };
      
      $.parser.plugins.push("mypanel");//注册扩展组件
      $.fn.mypanel = function (options, param) {//定义扩展组件

         //当options为字符串时，说明执行的是该插件的方法。
         if (typeof options == "string") { return $.fn.panel.apply(this,arguments); }

         //当该组件在一个页面出现多次时，this是一个集合，故需要通过each遍历。
         return  this.each(function () {

             //$.fn.combobox.parseOptions(this)作用是获取页面中的data-options中的配置
             var opts = $.extend({}, $.fn.panel.parseOptions(this), options);
             //把配置对象myopts放到$.fn.combobox这个函数中执行。
             var myopts = $.extend({}, opts,{ 
            	 //扩展点
             });
             $(this).panel(myopts);
             
         })
      };
      
      $.parser.plugins.push("mytooltip");//注册扩展组件
      $.fn.mytooltip = function (options, param) {//定义扩展组件

         //当options为字符串时，说明执行的是该插件的方法。
         if (typeof options == "string") { return $.fn.tooltip.apply(this,arguments); }

         //当该组件在一个页面出现多次时，this是一个集合，故需要通过each遍历。
         return  this.each(function () {

             //$.fn.combobox.parseOptions(this)作用是获取页面中的data-options中的配置
             var opts = $.extend({}, $.fn.tooltip.parseOptions(this), options);
             //把配置对象myopts放到$.fn.combobox这个函数中执行。
             var myopts = $.extend({}, opts,{ 
            	 //扩展点
             });
             $(this).tooltip(myopts);
             
         })
      };
      
      $.parser.plugins.push("myprogressbar");//注册扩展组件
      $.fn.myprogressbar = function (options, param) {//定义扩展组件

         //当options为字符串时，说明执行的是该插件的方法。
         if (typeof options == "string") { return $.fn.progressbar.apply(this,arguments); }

         //当该组件在一个页面出现多次时，this是一个集合，故需要通过each遍历。
         return  this.each(function () {

             //$.fn.combobox.parseOptions(this)作用是获取页面中的data-options中的配置
             var opts = $.extend({}, $.fn.progressbar.parseOptions(this), options);
             //把配置对象myopts放到$.fn.combobox这个函数中执行。
             var myopts = $.extend({}, opts,{ 
            	 //扩展点
             });
             $(this).progressbar(myopts);
             
         })
      };
      
      $.parser.plugins.push("mysearchbox");//注册扩展组件
      $.fn.mysearchbox = function (options, param) {//定义扩展组件

         //当options为字符串时，说明执行的是该插件的方法。
         if (typeof options == "string") { return $.fn.searchbox.apply(this,arguments); }

         //当该组件在一个页面出现多次时，this是一个集合，故需要通过each遍历。
         return  this.each(function () {

             //$.fn.combobox.parseOptions(this)作用是获取页面中的data-options中的配置
             var opts = $.extend({}, $.fn.searchbox.parseOptions(this), options);
             //把配置对象myopts放到$.fn.combobox这个函数中执行。
             var myopts = $.extend({}, opts,{ 
            	 //扩展点
             });
             $(this).searchbox(myopts);
             
         })
      };
      
      $.parser.plugins.push("mypagination");//注册扩展组件
      $.fn.mypagination = function (options, param) {//定义扩展组件

         //当options为字符串时，说明执行的是该插件的方法。
         if (typeof options == "string") { return $.fn.pagination.apply(this,arguments); }

         //当该组件在一个页面出现多次时，this是一个集合，故需要通过each遍历。
         return  this.each(function () {

             //$.fn.combobox.parseOptions(this)作用是获取页面中的data-options中的配置
             var opts = $.extend({}, $.fn.pagination.parseOptions(this), options);
             //把配置对象myopts放到$.fn.combobox这个函数中执行。
             var myopts = $.extend({}, opts,{ 
            	 //扩展点
             });
             $(this).pagination(myopts);
             
         })
      };
      
      $.parser.plugins.push("myresizable");//注册扩展组件
      $.fn.myresizable = function (options, param) {//定义扩展组件

         //当options为字符串时，说明执行的是该插件的方法。
         if (typeof options == "string") { return $.fn.resizable.apply(this,arguments); }

         //当该组件在一个页面出现多次时，this是一个集合，故需要通过each遍历。
         return  this.each(function () {

             //$.fn.combobox.parseOptions(this)作用是获取页面中的data-options中的配置
             var opts = $.extend({}, $.fn.resizable.parseOptions(this), options);
             //把配置对象myopts放到$.fn.combobox这个函数中执行。
             var myopts = $.extend({}, opts,{ 
            	 //扩展点
             });
             $(this).resizable(myopts);
             
         })
      };     
      $.parser.plugins.push("mydroppable");//注册扩展组件
      $.fn.mydroppable = function (options, param) {//定义扩展组件

         //当options为字符串时，说明执行的是该插件的方法。
         if (typeof options == "string") { return $.fn.droppable.apply(this,arguments); }

         //当该组件在一个页面出现多次时，this是一个集合，故需要通过each遍历。
         return  this.each(function () {

             //$.fn.combobox.parseOptions(this)作用是获取页面中的data-options中的配置
             var opts = $.extend({}, $.fn.droppable.parseOptions(this), options);
             //把配置对象myopts放到$.fn.combobox这个函数中执行。
             var myopts = $.extend({}, opts,{ 
            	 //扩展点
             });
             $(this).droppable(myopts);
             
         })
      }; 
      
      
      $.parser.plugins.push("mydraggable");//注册扩展组件
      $.fn.mydraggable = function (options, param) {//定义扩展组件

         //当options为字符串时，说明执行的是该插件的方法。
         if (typeof options == "string") { return $.fn.draggable.apply(this,arguments); }

         //当该组件在一个页面出现多次时，this是一个集合，故需要通过each遍历。
         return  this.each(function () {

             //$.fn.combobox.parseOptions(this)作用是获取页面中的data-options中的配置
             var opts = $.extend({}, $.fn.draggable.parseOptions(this), options);
             //把配置对象myopts放到$.fn.combobox这个函数中执行。
             var myopts = $.extend({}, opts,{ 
            	 //扩展点
             });
             $(this).draggable(myopts);
             
         })
      }; 
	})(jQuery);

 
  /***********************************
  * 
  * 1.easyui扩展组件 ckcombobox ,扩充combobox多选功能，使其选项里增加checkbox选择框
  * 2. 增加 onSelectByClickItem事件，当用户点击下拉框的item时触发
		 onSelectByClickItem:function(index, itemRow){}
  * @param $
  */
 (function($){
	  $.parser.plugins.push("ckcombobox");//注册扩展组件
      $.fn.ckcombobox = function (options, param) {//定义扩展组件

         //当options为字符串时，说明执行的是该插件的方法。
         if (typeof options == "string") { 
			 return $.fn.combobox.apply(this,arguments);
		  }
         options = options || {}; 

         //当该组件在一个页面出现多次时，this是一个集合，故需要通过each遍历。
         return  this.each(function () {

             //$.fn.combobox.parseOptions(this)作用是获取页面中的data-options中的配置
             var opts = $.extend({}, $.fn.combobox.parseOptions(this), options);
             //把配置对象myopts放到$.fn.combobox这个函数中执行。
             var myopts = $.extend({}, opts,{
							formatter : function(row){
								if(opts.formatter){
									var ret=opts.formatter.call(this, row);
								}
								 var opts2 = $(this).combobox("options");
								 if( row[opts2.valueField]=='-999999'){
										return "<span class='ckcombobox-xyz'  style='display:inline-block;width:100%'>[<a  href='javascript:void(0);' style='text-decoration:none;'>全选</a>] [<a  href='javascript:void(0);' style='text-decoration:none;'>全不选</a>] [<a style='text-decoration:none;'  href='javascript:void(0);'>反选</a>]</span>";
								 }
								 if(ret){
									 return "<input type='checkbox' class='combobox-checkbox'>" +ret;
								 }else{
									 return "<input type='checkbox' class='combobox-checkbox'>" + row[opts2.textField];
								 }

							},
							loadFilter: function(data){
								var opts2 = $(this).combobox("options");
								if(opts.loadFilter){
								   data=opts.loadFilter.call(this,data);
								}
								if(data && data.length>0){
									var obj={};
									obj[opts2.valueField]=-999999
									obj[opts2.textField]='全选,全不选,反选'
									data.unshift(obj);
								}
								return data;

							},
							onShowPanel : function(){

								///增加onSelectByClickItem事件
								var panel=$(this).combobox("panel");
								var target=this;
								$ (".combobox-item", panel).unbind ('click.ckcombobox').bind('click.ckcombobox',function (event) {
										var sindex = $(this).attr('id').lastIndexOf('_');
										var index = $(this).attr('id').substr(sindex + 1,$(this).attr('id').length - sindex - 1);
										var data = $(target).combobox ("getData");
										var itemRow=data[index];
										if(opts.onSelectByClickItem){
											opts.onSelectByClickItem.call(target, index-1,itemRow)
										}
										
								});
								if(opts.onShowPanel){
									var ret=opts.onShowPanel.call(this);
								}
								var opts2 = $(this).combobox("options");
								target = this;

								$(".ckcombobox-xyz").unbind('click.ckcombobox').bind('click.ckcombobox',function(event){
									event.stopPropagation();
									return false;
								});
								var comdata=$(target).combobox("getData");
									
								var valuesArray=$.map(comdata,function(item){
									if(item[opts2.valueField]==-999999){
										return null;
									}

									return item[opts2.valueField];
								});

								
								$(".ckcombobox-xyz a").unbind('click.ckcombobox').bind('click.ckcombobox',function(event){
									if($(this).text()=='全选'){
										
										$(target).combobox("setValues",valuesArray);
									}else if($(this).text()=='全不选'){
										$(target).combobox("setValues",[]);
									}if($(this).text()=='反选'){
										var comvalues = $(target).combobox("getValues");
										var novaluesArray=$.map(comdata,function(item){
											if(item[opts2.valueField]==-999999){
												return null;
											}
											if($.inArray(item[opts2.valueField]+'',comvalues)<0){
												return item[opts2.valueField];
											}
											return null;
										});
										$(target).combobox("setValues",novaluesArray);
									}
									event.stopPropagation();
									return false;

								});


								var values = $(target).combobox("getValues");
								$.map(values, function(value){
									var children = $(target).combobox("panel").children();
									$.each(children, function(index, obj){
										var row=$(target).combobox("getData")[index];
										if(value == row[opts2.valueField] && obj.children && obj.children.length > 0){
											obj.children[0].checked = true;
										}
									});
								});

								 
							},
							onLoadSuccess : function(){
								if(opts.onLoadSuccess){
									var ret=opts.onLoadSuccess.call(this);
								}
								var opts2 = $(this).combobox("options");
								var target = this;
								var values = $(target).combobox("getValues");
								$.map(values, function(value){
									var children = $(target).combobox("panel").children();
									$.each(children, function(index, obj){
										var row=$(target).combobox("getData")[index];
										if(value ==  row[opts2.valueField] && obj.children && obj.children.length > 0){
											obj.children[0].checked = true;
										}
									});
								});

								
							},

							onSelect : function(row){
								if(opts.onSelect){
									var ret=opts.onSelect.call(this,row);
								}
								var target = this;
								var opts2 = $(this).combobox("options");
								var objCom = null;
								var children = $(this).combobox("panel").children();
								$.each(children, function(index, obj){
									var row2=$(target).combobox("getData")[index];
									if(row[opts2.valueField] == row2[opts2.valueField]){
										objCom = obj;
									}
								});
								if(objCom != null && objCom.children && objCom.children.length > 0){
									objCom.children[0].checked = true;
								}

								
							},

							onUnselect : function(row){
								if(opts.onUnselect){
								   var ret=opts.onUnselect.call(this,row);
								}
								var target = this;
								var opts2 = $(this).combobox("options");
								var objCom = null;
								var children = $(this).combobox("panel").children();
								$.each(children, function(index, obj){
									var row2=$(target).combobox("getData")[index];
									if(row[opts2.valueField] == row2[opts2.valueField]){
									objCom = obj;
									}
								});
								if(objCom != null && objCom.children && objCom.children.length > 0){
									objCom.children[0].checked = false;
								}

								
							}
				});
				 $(this).combobox(myopts);
              //$.fn.combobox.call(this, myopts);
         });
     };


	})(jQuery);


 //在主框架页面的添加tab
 /**
  * title：选项卡名称
  * href:选项卡url
  * refresh：是否刷新，1 或 0
  */
 function addMyTab(title,href,refresh){
	 if(window.top){
		 window.top.addTab(title, href, refresh);
	 }
 }
 
 function closeMyTab(title){
	 if(window.top){
		 window.top.closeTab(title);
	 }
 }
 
 function activeMyTab(title){
	 if(window.top){
		 window.top.activeTab(title);
	 }
 }
 function findFrameInTab(title){
	 if(window.top){
		 return window.top.findFrameInTab(title);
	 }
	 return null;
 }
 function getCurPageTitle(){
	 return document.title;
 }
 /**
  * 向某个主框架tab发送数据，目标回调函数为receiveData;
  * @param title
  * @param fromsrcObj
  * @param data
  */
 function sendDataInTab(title,fromsrcObj,data){
	 var ret= findFrameInTab(title);
	 if(ret){
		 if(ret.contentWindow && ret.contentWindow.receiveData){
			 ret.contentWindow.receiveData(fromsrcObj,data);
		 }
	 }
 }
 /**清除easyui input 验证提示**/
 /**
  * target:选择器或jquery对象
  */
 function clearEasyUiInvalidTip(target){

	 $(target).find(".textbox-invalid").each(function(){
	
		 $(this).removeClass('textbox-invalid');
	 })
	 
	 //removeClass('textbox-invalid');
	 $(target).find(".validatebox-invalid").each(function(){

		 $(this).removeClass('validatebox-invalid');
	 });
	 
	// $(target).find("input").blur();

 }
 
 function addEasyUiInvalidTip(target){
	 var target=$(target).next("span").addClass("textbox-invalid");
	 target.find(".validatebox-text").addClass('validatebox-invalid');

 }
 

 

/**
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" >
<head>     
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />     
<title>图片上传本地预览</title>     
<style type="text/css">
#preview{width:500px;height:400px;border:1px solid #000;overflow:hidden;}

</style>
<link rel='stylesheet' type='text/css' href="js/jquery.imgareaselect/css/imgareaselect-default.css"/>
<script type="text/javascript" src="js/jquery.js"></script>

<script type="text/javascript" src="js/jquery.imgareaselect/scripts/jquery.imgareaselect.pack.js"></script>
<script type="text/javascript" src="js/jquery.plug/picview.js"></script>
<script type="text/javascript">

var rec={};
function get(){
	alert(rec.x1+","+rec.x2+"")
}
$(document).ready(function () {
	
    
});


</script>     
</head>     
<body>
<div id="preview" style="margin-left:600px;">
</div>

 <div id="sel" ></div> 

<div  id="crop" style="margin:10px;border:1px black solid;width: 160px;height:120px;overflow:hidden;position:relative;margin-left:600px;">
   
</div>
<br/>     
    <input type="file" onchange="viewImage(this,'preview','4:3','crop',rec)" />
       <input type="button" onclick="get()" value="获得坐标" />
    <div></div>
         
</body>     
</html>
 */
/**
 * SelectRec:含有x1,y1,x2,y2,width,height
 * 函数返回的对象包含图片的真实宽度（width）和高度（height）
 */

function fixAreaSelectBug(){
    $('.imgareaselect-selection').parent().remove();
    $("[class*='imgareaselect']").remove();
	
}
function viewImage(imgFile,previewDivId,cropDivId,SelectRec,SelectRatio,minRealSelWidth,minRealSelHeight,areaSelectSettings){
    
	fixAreaSelectBug();
	if(cropDivId ){

	
	    
	}
	
	var rec=localImage(imgFile,previewDivId,cropDivId);
	var n=10;
	if (cropDivId!=null ) {
		function getPicSize() {
			n--;
			if (n >= 0) {
				var flag=false;
				if (rec.width >= 0 && rec.height >= 0) {
					var displayHegiht=rec.displayHeight;
					var displayWidth =rec.displayWidth;
				
					var selMinWidth=0;
					var selMinHeight=0;
					var option={
							instance : true,
							handles : true,
							onSelectEnd : createSelectHander(
									rec, cropDivId, SelectRec)
				       };
					var floatRatio=1;
					if(SelectRatio=='auto'){
						option.onSelectEnd= createSelectAutoRadioHander(
								rec, cropDivId, SelectRec);
					}
					if(SelectRatio&& SelectRatio!='auto'&&SelectRatio!=''){
						option.aspectRatio=SelectRatio;
						var wh=SelectRatio.split(":");
						floatRatio=wh[0]/wh[1];
					}
					if(areaSelectSettings){
					   areaSelectSettings.parent=areaSelectSettings.parent||('#'+previewDivId);
					}else{
						areaSelectSettings={'parent':('#'+previewDivId)};
					}
					jQuery.extend(option, areaSelectSettings);
					
					if(minRealSelWidth>=0 ||minRealSelHeight>=0 ){
						
						if(minRealSelWidth==0){
							minRealSelWidth=rec.width;
							
						}
						if(minRealSelHeight==0){
							minRealSelHeight=rec.height;
						}
						if(SelectRatio&& SelectRatio!='auto'&&SelectRatio!=''){
							if(displayWidth/displayHegiht>=floatRatio){
								selMinHeight=Math.round((displayHegiht/rec.height)*minRealSelHeight);
								if(selMinHeight>0) {
									option.minHeight=selMinHeight;
									option.minWidth=Math.round((displayHegiht/rec.height)*minRealSelWidth);
									option.x1=0;
									option.y1=0;
									option.x2=option.minWidth;
									option.y2=option.minHeight;
									option.show=true;
									flag=true;
								};
							}else{
								selMinWidth=Math.round((displayWidth/rec.width)*minRealSelWidth);
								if(selMinWidth>0) {
									option.minWidth=selMinWidth;
									option.minHeight=Math.round((displayWidth/rec.width)*minRealSelHeight);
									option.x1=0;
									option.y1=0;
									option.x2=option.minWidth;
									option.y2=option.minHeight;
									option.show=true;
									flag=true;
								}
								
							}
						}
				    }else{
				    	option.show=false;
				    }
					
			    	AreaSelect = $('#' + previewDivId + '_IMG').imgAreaSelect(option);/////
			    	if (flag) {
			    		(createSelectHander(rec, cropDivId, SelectRec))(
			    			{width:rec.displayWidth,height:rec.displayHeight},
			    			{x1:option.x1,y1:option.y1,x2:option.x2,y2:option.y2,
			    				width:option.minWidth,height:option.minHeight});
			    	}
			    	
			    	return;
				
				} else {
					setTimeout(getPicSize, 500);
				}
			}else{
				return;
			}
		}
		setTimeout(getPicSize, 500);
	}else{
		
		
	}

	return rec;

	//alert(rec.width+","+rec.height);

	
}

function createSelectHander(rec,cropDivId,SelectRec){
	

	 return  function preview(img, selection) {
	
		   var scaleX = rec.width / (img.width!=null?img.width:img.offsetWidth );
		   var scaleY = rec.height / (img.height!=null?img.height:img.offsetHeight );
		    
		   var width =  (selection.width || 1);
		   var height =  (selection.height || 1);
		   

		
		   var swidth= scaleX * width;
		   var sheight=scaleY * height;
		   var sleft=scaleX * selection.x1;
		   var stop=scaleY * selection.y1;
		   SelectRec.selx1=selection.x1;
		   SelectRec.sely1=selection.y1;
		   SelectRec.selx2=selection.x2;
		   SelectRec.sely2=selection.y2;
		   SelectRec.selWidth=selection.width;
		   SelectRec.selHeight=selection.height;
		   SelectRec.selPicWidth=rec.displayWidth;
		   SelectRec.selPicHeight=rec.displayHeight;
		   SelectRec.picRealWidth=rec.width;
		   SelectRec.picRealHeight=rec.height;
		  if(cropDivId && cropDivId!=null){
			   var divW=$("#"+cropDivId).width();
			   var divH=$("#"+cropDivId).height();
			  
			   var w=Math.round(rec.width*(divW/swidth));
			   var h=Math.round(rec.height*(divH/sheight));
			   var ml=Math.round(sleft*(divW/swidth));
			   var mt=Math.round(stop*(divH/sheight));   	
			   
			   $("#"+cropDivId+"_IMG").css({
			    'width': w+ 'px',
			    'height': h + 'px',
			    'margin-left': '-' +ml + 'px',
			    'margin-top': '-' + mt + 'px'
			   });
		  }
	};
}

function createSelectAutoRadioHander(rec,cropDivId,SelectRec){
	

	 return  function preview(img, selection) {
	
		   var scaleX = rec.width / (img.width!=null?img.width:img.offsetWidth );
		   var scaleY = rec.height / (img.height!=null?img.height:img.offsetHeight );
		    
		   var width =  (selection.width || 1);
		   var height =  (selection.height || 1);
		   

		
		   var swidth= scaleX * width;
		   var sheight=scaleY * height;
		   var sleft=scaleX * selection.x1;
		   var stop=scaleY * selection.y1;
		   SelectRec.selx1=selection.x1;
		   SelectRec.sely1=selection.y1;
		   SelectRec.selx2=selection.x2;
		   SelectRec.sely2=selection.y2;
		   SelectRec.selWidth=selection.width;
		   SelectRec.selHeight=selection.height;
		   SelectRec.selPicWidth=rec.displayWidth;
		   SelectRec.selPicHeight=rec.displayHeight;
		   SelectRec.picRealWidth=rec.width;
		   SelectRec.picRealHeight=rec.height;
		   //divW 真实的宽度,divH 真实的高度
		   var w=null;
		   var h=null;
		   var ml=null;
		   var mt=null;
		   if(cropDivId && cropDivId!=''){
			   var divW=$("#"+cropDivId).width();
			   var divH=$("#"+cropDivId).height();
			   $("#"+cropDivId).css("text-align","center");
			   if(divW/divH >= swidth/sheight ){
				  w=Math.round(rec.width*(divH/swidth));
				  h=Math.round(rec.height*(divH/sheight));
				  ml=Math.round(sleft*(divH/swidth));
				  mt=Math.round(stop*(divH/sheight));
			   }else{
				  w=Math.round(rec.width*(divW/swidth));
				  h=Math.round(rec.height*(divW/sheight));
				  ml=Math.round(sleft*(divW/swidth));
				  mt=Math.round(stop*(divW/sheight));
			   }
			   
			   $("#"+cropDivId+"_IMG").css({
			    'width': w+ 'px',
			    'height': h + 'px',
			    'margin-left': '-' +ml + 'px',
			    'margin-top': '-' + mt + 'px'
			   });
		   }
	};
}

function localImage(file,imgdivid,cropid)
{
  var div = document.getElementById(imgdivid);
  var cropdiv=null;
  if(cropid && cropid!=''){
	  cropdiv = document.getElementById(cropid);
  }
  var picRec={
		  
  };
  var max_height=div.offsetHeight;
  var max_width=div.offsetWidth;
  if (file.files && file.files[0])
  {
      div.innerHTML = '<img id='+imgdivid+'_IMG>';
      var img = document.getElementById(imgdivid+'_IMG');
      
      var cropimg=null;
      if(cropid && cropid!=''){
    	  cropdiv.innerHTML = '<img id='+cropid+'_IMG style="width:0;height:0">';
    	  cropimg=document.getElementById(cropid+'_IMG');
      }
   
      img.onload = function(){
    	  
    	picRec.width=img.width;
    	picRec.height=img.height;
        var rect = clacImgZoomParam(max_width, max_height, img.width, img.height);
        img.width = rect.width;
        img.height = rect.height;
        picRec.displayWidth=rect.width;
        picRec.displayHeight=rect.height;
        img.style.marginLeft = rect.left+'px';
        img.style.marginTop = rect.top+'px';
      };
      if(cropimg){
    	  cropimg.onload = function(){
    	   // rect = clacImgZoomParam(cropdiv.offsetWidth, cropdiv.offsetHeight, cropimg.offsetWidth, cropimg.offsetHeight);
    	    cropimg.width =0;
    	    cropimg.height = 0;
    	    cropimg.style.marginLeft = 0+'px';
    	    cropimg.style.marginTop = 0+'px';
    	  };
        }
      var reader = new FileReader();
      reader.onload = function(evt){
    	  img.src = evt.target.result;
    	  if(cropimg){
    		  cropimg.src=evt.target.result;

          }
      }
      reader.readAsDataURL(file.files[0]);
  }
  else
  {
    var sFilter='filter:progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale,src="';
    file.select();
    var src = document.selection.createRange().text;
     div.innerHTML = '<img  id="'+imgdivid+'_IMG" style="filter:progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=image);">';
     if(cropid && cropid!=''){
   	  cropdiv.innerHTML = '<img id='+cropid+'_IMG>';
  	  crop_img=document.getElementById(cropid+'_IMG');
     }
    
    var img = document.getElementById(imgdivid+'_IMG');

    img.filters.item('DXImageTransform.Microsoft.AlphaImageLoader').src = src;
    picRec.width=img.offsetWidth;//img.width;
    picRec.height=img.offsetHeight; //
    var rect = clacImgZoomParam(max_width, max_height, img.offsetWidth, img.offsetHeight);
    
    picRec.displayWidth=rect.width;
    picRec.displayHeight=rect.height;
   // status =('rect:'+rect.top+','+rect.left+','+rect.width+','+rect.height);
    
    div.innerHTML = "<div id='"+imgdivid+"_IMG' style='width:"+rect.width+"px;height:"+rect.height+"px;margin-top:"+rect.top+"px;margin-left:"+rect.left+"px;"+sFilter+src+"\");'></div>";
    
    if(cropid && cropid!=''){
       // rect = clacImgZoomParam(cropdiv.offsetWidth, cropdiv.offsetHeight, img.offsetWidth, img.offsetHeight);
        cropdiv.innerHTML = "<div id='"+cropid+"_IMG' style='width:0px;height:0px;margin-top:0px;margin-left:0px;"+sFilter+src+"\");'></div>";
        
        
    }
  }
  return picRec;
}
function clacImgZoomParam( maxWidth, maxHeight, width, height ){
    var param = {top:0, left:0, width:width, height:height};
    if( width>maxWidth || height>maxHeight )
    {
        rateWidth = width / maxWidth;
        rateHeight = height / maxHeight;
        
        if( rateWidth > rateHeight )
        {
            param.width =  maxWidth;
            param.height = Math.round( (height*maxWidth) / width);
        }else
        {
            param.width = Math.round((width * maxHeight) /height);
            param.height = maxHeight;
        }
    }
    
    param.left = Math.round((maxWidth - param.width) / 2);
    param.top = Math.round((maxHeight - param.height) / 2);
    return param;
}
/**
 
    SelectRec.selx1=selection.x1;
	SelectRec.sely1=selection.y1;
	SelectRec.selx2=selection.x2;
	SelectRec.sely2=selection.y2;
	SelectRec.selWidth=selection.width;
	SelectRec.selHeight=selection.height;
	SelectRec.selPicWidth=rec.displayWidth;
	SelectRec.selPicHeight=rec.displayHeight;
	SelectRec.picRealWidth=rec.width;
	SelectRec.picRealHeight=rec.height;
 * @param SelectRec
 */
function getRealSelectRec(SelectRec){
	var RealSelRec={
			selx1:0,
			sely1:0,
			selx2:0,
			sely2:0,
			selWidth:0,
			selHeight:0	
	};
	if(SelectRec.selx1 !=undefined && SelectRec.selx1 !=null ){
		var  scalew=SelectRec.picRealWidth/SelectRec.selPicWidth;
		var  scaleh = SelectRec.picRealHeight/SelectRec.selPicHeight;
		
		RealSelRec.selx1=Math.round(scalew*SelectRec.selx1);
		RealSelRec.sely1=Math.round(scaleh*SelectRec.sely1);
		RealSelRec.selx2=Math.round(scalew*SelectRec.selx2);
		RealSelRec.sely2=Math.round(scaleh*SelectRec.sely2);
		RealSelRec.selWidth=Math.round(scalew*SelectRec.selWidth);
		RealSelRec.selHeight=Math.round(scaleh*SelectRec.selHeight);
	}
	return RealSelRec;
	
}

function PicCenterZoom(img){
	$(img).parent().css("text-align","left");
	var image = new Image();
    var rw=0;
    var rh=0;
	image.src = img.src;
	if (image.complete) {
		rw=image.width;
		rh=image.height;
	} else {
		image.onload = function () {
			rw=image.width;
			rh=image.height;
		};
	};
	var max_width =$(img).parent().width();
	var max_height=$(img).parent().height();
	var rect=clacImgZoomParam(max_width, max_height, rw, rh);
	img.width = rect.width;
    img.height = rect.height;
    img.style.marginLeft = rect.left+'px';
    img.style.marginTop = rect.top+'px';
}



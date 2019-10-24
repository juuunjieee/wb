/*! art-template@4.12.2 for browser | https://github.com/aui/art-template */
!function(e,t){"object"==typeof exports&&"object"==typeof module?module.exports=t():"function"==typeof define&&define.amd?define([],t):"object"==typeof exports?exports.template=t():e.template=t()}(this,function(){return function(e){function t(r){if(n[r])return n[r].exports;var i=n[r]={i:r,l:!1,exports:{}};return e[r].call(i.exports,i,i.exports,t),i.l=!0,i.exports}var n={};return t.m=e,t.c=n,t.d=function(e,n,r){t.o(e,n)||Object.defineProperty(e,n,{configurable:!1,enumerable:!0,get:r})},t.n=function(e){var n=e&&e.__esModule?function(){return e["default"]}:function(){return e};return t.d(n,"a",n),n},t.o=function(e,t){return Object.prototype.hasOwnProperty.call(e,t)},t.p="",t(t.s=6)}([function(e,t,n){(function(t){e.exports=!1;try{e.exports="[object process]"===Object.prototype.toString.call(t.process)}catch(n){}}).call(t,n(4))},function(e,t,n){"use strict";var r=n(8),i=n(3),o=n(23),s=function(e,t){t.onerror(e,t);var n=function(){return"{Template Error}"};return n.mappings=[],n.sourcesContent=[],n},a=function c(e){var t=arguments.length>1&&arguments[1]!==undefined?arguments[1]:{};"string"!=typeof e?t=e:t.source=e,t=i.$extend(t),e=t.source,!0===t.debug&&(t.cache=!1,t.minimize=!1,t.compileDebug=!0),t.compileDebug&&(t.minimize=!1),t.filename&&(t.filename=t.resolveFilename(t.filename,t));var n=t.filename,a=t.cache,u=t.caches;if(a&&n){var p=u.get(n);if(p)return p}if(!e)try{e=t.loader(n,t),t.source=e}catch(d){var l=new o({name:"CompileError",path:n,message:"template not found: "+d.message,stack:d.stack});if(t.bail)throw l;return s(l,t)}var f=void 0,h=new r(t);try{f=h.build()}catch(l){if(l=new o(l),t.bail)throw l;return s(l,t)}var m=function(e,n){try{return f(e,n)}catch(l){if(!t.compileDebug)return t.cache=!1,t.compileDebug=!0,c(t)(e,n);if(l=new o(l),t.bail)throw l;return s(l,t)()}};return m.mappings=f.mappings,m.sourcesContent=f.sourcesContent,m.toString=function(){return f.toString()},a&&n&&u.set(n,m),m};a.Compiler=r,e.exports=a},function(e,t){Object.defineProperty(t,"__esModule",{value:!0}),t["default"]=/((['"])(?:(?!\2|\\).|\\(?:\r\n|[\s\S]))*(\2)?|`(?:[^`\\$]|\\[\s\S]|\$(?!\{)|\$\{(?:[^{}]|\{[^}]*\}?)*\}?)*(`)?)|(\/\/.*)|(\/\*(?:[^*]|\*(?!\/))*(\*\/)?)|(\/(?!\*)(?:\[(?:(?![\]\\]).|\\.)*\]|(?![\/\]\\]).|\\.)+\/(?:(?!\s*(?:\b|[\u0080-\uFFFF$\\'"~({]|[+\-!](?!=)|\.?\d))|[gmiyu]{1,5}\b(?![\u0080-\uFFFF$\\]|\s*(?:[+\-*%&|^<>!=?({]|\/(?![\/*])))))|(0[xX][\da-fA-F]+|0[oO][0-7]+|0[bB][01]+|(?:\d*\.\d+|\d+\.?)(?:[eE][+-]?\d+)?)|((?!\d)(?:(?!\s)[$\w\u0080-\uFFFF]|\\u[\da-fA-F]{4}|\\u\{[\da-fA-F]+\})+)|(--|\+\+|&&|\|\||=>|\.{3}|(?:[+\-\/%&|^]|\*{1,2}|<{1,2}|>{1,3}|!=?|={1,2})=?|[?~.,:;[\](){}])|(\s+)|(^$|[\s\S])/g,t.matchToToken=function(e){var t={type:"invalid",value:e[0]};return e[1]?(t.type="string",t.closed=!(!e[3]&&!e[4])):e[5]?t.type="comment":e[6]?(t.type="comment",t.closed=!!e[7]):e[8]?t.type="regex":e[9]?t.type="number":e[10]?t.type="name":e[11]?t.type="punctuator":e[12]&&(t.type="whitespace"),t}},function(e,t,n){"use strict";function r(){this.$extend=function(e){return e=e||{},s(e,e instanceof r?e:this)}}var i=n(0),o=n(12),s=n(13),a=n(14),c=n(15),u=n(16),p=n(17),l=n(18),f=n(19),h=n(20),m=n(22),d={source:null,filename:null,rules:[f,l],escape:!0,debug:!!i&&"production"!==process.env.NODE_ENV,bail:!0,cache:!0,minimize:!0,compileDebug:!1,resolveFilename:m,include:a,htmlMinifier:h,htmlMinifierOptions:{collapseWhitespace:!0,minifyCSS:!0,minifyJS:!0,ignoreCustomFragments:[]},onerror:c,loader:p,caches:u,root:"/",extname:".art",ignore:[],imports:o};r.prototype=d,e.exports=new r},function(e,t){var n;n=function(){return this}();try{n=n||Function("return this")()||(0,eval)("this")}catch(r){"object"==typeof window&&(n=window)}e.exports=n},function(e,t){},function(e,t,n){"use strict";var r=n(7),i=n(1),o=n(24),s=function(e,t){return t instanceof Object?r({filename:e},t):i({filename:e,source:t})};s.render=r,s.compile=i,s.defaults=o,e.exports=s},function(e,t,n){"use strict";var r=n(1),i=function(e,t,n){return r(e,n)(t)};e.exports=i},function(e,t,n){"use strict";function r(e,t){if(!(e instanceof t))throw new TypeError("Cannot call a class as a function")}var i=n(9),o=n(11),s="$data",a="$imports",c="print",u="include",p="extend",l="block",f="$$out",h="$$line",m="$$blocks",d="$$slice",v="$$from",g="$$options",y=function(e,t){return Object.hasOwnProperty.call(e,t)},b=JSON.stringify,x=function(){function e(t){var n,i,y=this;r(this,e);var b=t.source,x=t.minimize,w=t.htmlMinifier;if(this.options=t,this.stacks=[],this.context=[],this.scripts=[],this.CONTEXT_MAP={},this.ignore=[s,a,g].concat(t.ignore),this.internal=(n={},n[f]="''",n[h]="[0,0]",n[m]="arguments[1]||{}",n[v]="null",n[c]="function(){var s=''.concat.apply('',arguments);"+f+"+=s;return s}",n[u]="function(src,data){var s="+g+".include(src,data||"+s+",arguments[2]||"+m+","+g+");"+f+"+=s;return s}",n[p]="function(from){"+v+"=from}",n[d]="function(c,p,s){p="+f+";"+f+"='';c();s="+f+";"+f+"=p+s;return s}",n[l]="function(){var a=arguments,s;if(typeof a[0]==='function'){return "+d+"(a[0])}else if("+v+"){"+m+"[a[0]]="+d+"(a[1])}else{s="+m+"[a[0]];if(typeof s==='string'){"+f+"+=s}else{s="+d+"(a[1])}return s}}",n),this.dependencies=(i={},i[c]=[f],i[u]=[f,g,s,m],i[p]=[v,u],i[l]=[d,v,f,m],i),this.importContext(f),t.compileDebug&&this.importContext(h),x)try{b=w(b,t)}catch(E){}this.source=b,this.getTplTokens(b,t.rules,this).forEach(function(e){e.type===o.TYPE_STRING?y.parseString(e):y.parseExpression(e)})}return e.prototype.getTplTokens=function(){return o.apply(undefined,arguments)},e.prototype.getEsTokens=function(e){return i(e)},e.prototype.getVariables=function(e){var t=!1;return e.filter(function(e){return"whitespace"!==e.type&&"comment"!==e.type}).filter(function(e){return"name"===e.type&&!t||(t="punctuator"===e.type&&"."===e.value,!1)}).map(function(e){return e.value})},e.prototype.importContext=function(e){var t=this,n="",r=this.internal,i=this.dependencies,o=this.ignore,c=this.context,u=this.options,p=u.imports,l=this.CONTEXT_MAP;y(l,e)||-1!==o.indexOf(e)||(y(r,e)?(n=r[e],y(i,e)&&i[e].forEach(function(e){return t.importContext(e)})):n="$escape"===e||"$each"===e||y(p,e)?a+"."+e:s+"."+e,l[e]=n,c.push({name:e,value:n}))},e.prototype.parseString=function(e){var t=e.value;if(t){var n=f+"+="+b(t);this.scripts.push({source:t,tplToken:e,code:n})}},e.prototype.parseExpression=function(e){var t=this,n=e.value,r=e.script,i=r.output,s=this.options.escape,a=r.code;i&&(a=!1===s||i===o.TYPE_RAW?f+"+="+r.code:f+"+=$escape("+r.code+")");var c=this.getEsTokens(a);this.getVariables(c).forEach(function(e){return t.importContext(e)}),this.scripts.push({source:n,tplToken:e,code:a})},e.prototype.checkExpression=function(e){for(var t=[[/^\s*}[\w\W]*?{?[\s;]*$/,""],[/(^[\w\W]*?\([\w\W]*?(?:=>|\([\w\W]*?\))\s*{[\s;]*$)/,"$1})"],[/(^[\w\W]*?\([\w\W]*?\)\s*{[\s;]*$)/,"$1}"]],n=0;n<t.length;){if(t[n][0].test(e)){var r;e=(r=e).replace.apply(r,t[n]);break}n++}try{return new Function(e),!0}catch(i){return!1}},e.prototype.build=function(){var e=this.options,t=this.context,n=this.scripts,r=this.stacks,i=this.source,c=e.filename,l=e.imports,d=[],x=y(this.CONTEXT_MAP,p),w=0,E=function(e,t){var n=t.line,i=t.start,o={generated:{line:r.length+w+1,column:1},original:{line:n+1,column:i+1}};return w+=e.split(/\n/).length-1,o},k=function(e){return e.replace(/^[\t ]+|[\t ]$/g,"")};r.push("function("+s+"){"),r.push("'use strict'"),r.push(s+"="+s+"||{}"),r.push("var "+t.map(function(e){return e.name+"="+e.value}).join(",")),e.compileDebug?(r.push("try{"),n.forEach(function(e){e.tplToken.type===o.TYPE_EXPRESSION&&r.push(h+"=["+[e.tplToken.line,e.tplToken.start].join(",")+"]"),d.push(E(e.code,e.tplToken)),r.push(k(e.code))}),r.push("}catch(error){"),r.push("throw {"+["name:'RuntimeError'","path:"+b(c),"message:error.message","line:"+h+"[0]+1","column:"+h+"[1]+1","source:"+b(i),"stack:error.stack"].join(",")+"}"),r.push("}")):n.forEach(function(e){d.push(E(e.code,e.tplToken)),r.push(k(e.code))}),x&&(r.push(f+"=''"),r.push(u+"("+v+","+s+","+m+")")),r.push("return "+f),r.push("}");var T=r.join("\n");try{var O=new Function(a,g,"return "+T)(l,e);return O.mappings=d,O.sourcesContent=[i],O}catch(F){for(var $=0,j=0,S=0,_=void 0;$<n.length;){var C=n[$];if(!this.checkExpression(C.code)){j=C.tplToken.line,S=C.tplToken.start,_=C.code;break}$++}throw{name:"CompileError",path:c,message:F.message,line:j+1,column:S+1,source:i,generated:_,stack:F.stack}}},e}();x.CONSTS={DATA:s,IMPORTS:a,PRINT:c,INCLUDE:u,EXTEND:p,BLOCK:l,OPTIONS:g,OUT:f,LINE:h,BLOCKS:m,SLICE:d,FROM:v,ESCAPE:"$escape",EACH:"$each"},e.exports=x},function(e,t,n){"use strict";var r=n(10),i=n(2)["default"],o=n(2).matchToToken,s=function(e){return e.match(i).map(function(e){return i.lastIndex=0,o(i.exec(e))}).map(function(e){return"name"===e.type&&r(e.value)&&(e.type="keyword"),e})};e.exports=s},function(e,t,n){"use strict";var r={"abstract":!0,await:!0,"boolean":!0,"break":!0,"byte":!0,"case":!0,"catch":!0,"char":!0,"class":!0,"const":!0,"continue":!0,"debugger":!0,"default":!0,"delete":!0,"do":!0,"double":!0,"else":!0,"enum":!0,"export":!0,"extends":!0,"false":!0,"final":!0,"finally":!0,"float":!0,"for":!0,"function":!0,"goto":!0,"if":!0,"implements":!0,"import":!0,"in":!0,"instanceof":!0,"int":!0,"interface":!0,"let":!0,"long":!0,"native":!0,"new":!0,"null":!0,"package":!0,"private":!0,"protected":!0,"public":!0,"return":!0,"short":!0,"static":!0,"super":!0,"switch":!0,"synchronized":!0,"this":!0,"throw":!0,"transient":!0,"true":!0,"try":!0,"typeof":!0,"var":!0,"void":!0,"volatile":!0,"while":!0,"with":!0,"yield":!0};e.exports=function(e){return r.hasOwnProperty(e)}},function(e,t,n){"use strict";function r(e,t,n,r){var i=new String(e);return i.line=t,i.start=n,i.end=r,i}var i=function(e,t){for(var n=arguments.length>2&&arguments[2]!==undefined?arguments[2]:{},i=[{type:"string",value:e,line:0,start:0,end:e.length}],o=0;o<t.length;o++)!function(e){for(var t=e.test.ignoreCase?"ig":"g",o=e.test.source+"|^$|[\\w\\W]",s=new RegExp(o,t),a=0;a<i.length;a++)if("string"===i[a].type){for(var c=i[a].line,u=i[a].start,p=i[a].end,l=i[a].value.match(s),f=[],h=0;h<l.length;h++){var m=l[h];e.test.lastIndex=0;var d=e.test.exec(m),v=d?"expression":"string",g=f[f.length-1],y=g||i[a],b=y.value;u=y.line===c?g?g.end:u:b.length-b.lastIndexOf("\n")-1,p=u+m.length;var x={type:v,value:m,line:c,start:u,end:p};if("string"===v)g&&"string"===g.type?(g.value+=m,g.end+=m.length):f.push(x);else{d[0]=new r(d[0],c,u,p);var w=e.use.apply(n,d);x.script=w,f.push(x)}c+=m.split(/\n/).length-1}i.splice.apply(i,[a,1].concat(f)),a+=f.length-1}}(t[o]);return i};i.TYPE_STRING="string",i.TYPE_EXPRESSION="expression",i.TYPE_RAW="raw",i.TYPE_ESCAPE="escape",e.exports=i},function(e,t,n){"use strict";(function(t){function r(e){return"string"!=typeof e&&(e=e===undefined||null===e?"":"function"==typeof e?r(e.call(e)):JSON.stringify(e)),e}function i(e){var t=""+e,n=a.exec(t);if(!n)return e;var r="",i=void 0,o=void 0,s=void 0;for(i=n.index,o=0;i<t.length;i++){switch(t.charCodeAt(i)){case 34:s="&#34;";break;case 38:s="&#38;";break;case 39:s="&#39;";break;case 60:s="&#60;";break;case 62:s="&#62;";break;default:continue}o!==i&&(r+=t.substring(o,i)),o=i+1,r+=s}return o!==i?r+t.substring(o,i):r}/*! art-template@runtime | https://github.com/aui/art-template */
var o=n(0),s=Object.create(o?t:window),a=/["&'<>]/;s.$escape=function(e){return i(r(e))},s.$each=function(e,t){if(Array.isArray(e))for(var n=0,r=e.length;n<r;n++)t(e[n],n);else for(var i in e)t(e[i],i)},e.exports=s}).call(t,n(4))},function(e,t,n){"use strict";var r=Object.prototype.toString,i=function(e){return null===e?"Null":r.call(e).slice(8,-1)},o=function s(e,t){var n=void 0,r=i(e);if("Object"===r?n=Object.create(t||{}):"Array"===r&&(n=[].concat(t||[])),n){for(var o in e)Object.hasOwnProperty.call(e,o)&&(n[o]=s(e[o],n[o]));return n}return e};e.exports=o},function(e,t,n){"use strict";var r=function(e,t,r,i){var o=n(1);return i=i.$extend({filename:i.resolveFilename(e,i),bail:!0,source:null}),o(i)(t,r)};e.exports=r},function(e,t,n){"use strict";var r=function(e){console.error(e.name,e.message)};e.exports=r},function(e,t,n){"use strict";var r={__data:Object.create(null),set:function(e,t){this.__data[e]=t},get:function(e){return this.__data[e]},reset:function(){this.__data={}}};e.exports=r},function(e,t,n){"use strict";var r=n(0),i=function(e){if(r){return n(5).readFileSync(e,"utf8")}var t=document.getElementById(e);return t.value||t.innerHTML};e.exports=i},function(e,t,n){"use strict";var r={test:/{{([@#]?)[ \t]*(\/?)([\w\W]*?)[ \t]*}}/,use:function(e,t,n,i){var o=this,s=o.options,a=o.getEsTokens(i),c=a.map(function(e){return e.value}),u={},p=void 0,l=!!t&&"raw",f=n+c.shift(),h=function(t,n){console.warn((s.filename||"anonymous")+":"+(e.line+1)+":"+(e.start+1)+"\nTemplate upgrade: {{"+t+"}} -> {{"+n+"}}")};switch("#"===t&&h("#value","@value"),f){case"set":i="var "+c.join("").trim();break;case"if":i="if("+c.join("").trim()+"){";break;case"else":var m=c.indexOf("if");~m?(c.splice(0,m+1),i="}else if("+c.join("").trim()+"){"):i="}else{";break;case"/if":i="}";break;case"each":p=r._split(a),p.shift(),"as"===p[1]&&(h("each object as value index","each object value index"),p.splice(1,1));i="$each("+(p[0]||"$data")+",function("+(p[1]||"$value")+","+(p[2]||"$index")+"){";break;case"/each":i="})";break;case"block":p=r._split(a),p.shift(),i="block("+p.join(",").trim()+",function(){";break;case"/block":i="})";break;case"echo":f="print",h("echo value","value");case"print":case"include":case"extend":if(0!==c.join("").trim().indexOf("(")){p=r._split(a),p.shift(),i=f+"("+p.join(",")+")";break}default:if(~c.indexOf("|")){var d=a.reduce(function(e,t){var n=t.value,r=t.type;return"|"===n?e.push([]):"whitespace"!==r&&"comment"!==r&&(e.length||e.push([]),":"===n&&1===e[e.length-1].length?h("value | filter: argv","value | filter argv"):e[e.length-1].push(t)),e},[]).map(function(e){return r._split(e)});i=d.reduce(function(e,t){var n=t.shift();return t.unshift(e),"$imports."+n+"("+t.join(",")+")"},d.shift().join(" ").trim())}l=l||"escape"}return u.code=i,u.output=l,u},_split:function(e){e=e.filter(function(e){var t=e.type;return"whitespace"!==t&&"comment"!==t});for(var t=0,n=e.shift(),r=/\]|\)/,i=[[n]];t<e.length;){var o=e[t];"punctuator"===o.type||"punctuator"===n.type&&!r.test(n.value)?i[i.length-1].push(o):i.push([o]),n=o,t++}return i.map(function(e){return e.map(function(e){return e.value}).join("")})}};e.exports=r},function(e,t,n){"use strict";var r={test:/<%(#?)((?:==|=#|[=-])?)[ \t]*([\w\W]*?)[ \t]*(-?)%>/,use:function(e,t,n,r){return n={"-":"raw","=":"escape","":!1,"==":"raw","=#":"raw"}[n],t&&(r="/*"+r+"*/",n=!1),{code:r,output:n}}};e.exports=r},function(e,t,n){"use strict";var r=n(0),i=function(e,t){if(r){var i,o=n(21).minify,s=t.htmlMinifierOptions,a=t.rules.map(function(e){return e.test});(i=s.ignoreCustomFragments).push.apply(i,a),e=o(e,s)}return e};e.exports=i},function(e,t){!function(e){e.noop=function(){}}("object"==typeof e&&"object"==typeof e.exports?e.exports:window)},function(e,t,n){"use strict";var r=n(0),i=/^\.+\//,o=function(e,t){if(r){var o=n(5),s=t.root,a=t.extname;if(i.test(e)){var c=t.filename,u=!c||e===c,p=u?s:o.dirname(c);e=o.resolve(p,e)}else e=o.resolve(s,e);o.extname(e)||(e+=a)}return e};e.exports=o},function(e,t,n){"use strict";function r(e,t){if(!(e instanceof t))throw new TypeError("Cannot call a class as a function")}function i(e,t){if(!e)throw new ReferenceError("this hasn't been initialised - super() hasn't been called");return!t||"object"!=typeof t&&"function"!=typeof t?e:t}function o(e,t){if("function"!=typeof t&&null!==t)throw new TypeError("Super expression must either be null or a function, not "+typeof t);e.prototype=Object.create(t&&t.prototype,{constructor:{value:e,enumerable:!1,writable:!0,configurable:!0}}),t&&(Object.setPrototypeOf?Object.setPrototypeOf(e,t):e.__proto__=t)}function s(e){var t=e.name,n=e.source,r=e.path,i=e.line,o=e.column,s=e.generated,a=e.message;if(!n)return a;var c=n.split(/\n/),u=Math.max(i-3,0),p=Math.min(c.length,i+3),l=c.slice(u,p).map(function(e,t){var n=t+u+1;return(n===i?" >> ":"    ")+n+"| "+e}).join("\n");return(r||"anonymous")+":"+i+":"+o+"\n"+l+"\n\n"+t+": "+a+(s?"\n   generated: "+s:"")}var a=function(e){function t(n){r(this,t);var o=i(this,e.call(this,n.message));return o.name="TemplateError",o.message=s(n),Error.captureStackTrace&&Error.captureStackTrace(o,o.constructor),o}return o(t,e),t}(Error);e.exports=a},function(e,t,n){"use strict";e.exports=n(3)}])});/**
 * jQuery JSON plugin 2.4-alpha
 *
 * @author Brantley Harris, 2009-2011
 * @author Timo Tijhof, 2011-2012
 * @source This plugin is heavily influenced by MochiKit's serializeJSON, which is
 *         copyrighted 2005 by Bob Ippolito.
 * @source Brantley Harris wrote this plugin. It is based somewhat on the JSON.org
 *         website's http://www.json.org/json2.js, which proclaims:
 *         "NO WARRANTY EXPRESSED OR IMPLIED. USE AT YOUR OWN RISK.", a sentiment that
 *         I uphold.
 * @license MIT License <http://www.opensource.org/licenses/mit-license.php>
 */
(function ($) {
	'use strict';

	var escape = /["\\\x00-\x1f\x7f-\x9f]/g,
		meta = {
			'\b': '\\b',
			'\t': '\\t',
			'\n': '\\n',
			'\f': '\\f',
			'\r': '\\r',
			'"' : '\\"',
			'\\': '\\\\'
		},
		hasOwn = Object.prototype.hasOwnProperty;

	/**
	 * jQuery.toJSON
	 * Converts the given argument into a JSON representation.
	 *
	 * @param o {Mixed} The json-serializable *thing* to be converted
	 *
	 * If an object has a toJSON prototype, that will be used to get the representation.
	 * Non-integer/string keys are skipped in the object, as are keys that point to a
	 * function.
	 *
	 */
	$.toJSON = typeof JSON === 'object' && JSON.stringify ? JSON.stringify : function (o) {
		if (o === null) {
			return 'null';
		}

		var pairs, k, name, val,
			type = $.type(o);

		if (type === 'undefined') {
			return undefined;
		}

		// Also covers instantiated Number and Boolean objects,
		// which are typeof 'object' but thanks to $.type, we
		// catch them here. I don't know whether it is right
		// or wrong that instantiated primitives are not
		// exported to JSON as an {"object":..}.
		// We choose this path because that's what the browsers did.
		if (type === 'number' || type === 'boolean') {
			return String(o);
		}
		if (type === 'string') {
			return $.quoteString(o);
		}
		if (typeof o.toJSON === 'function') {
			return $.toJSON(o.toJSON());
		}
		if (type === 'date') {
			var month = o.getUTCMonth() + 1,
				day = o.getUTCDate(),
				year = o.getUTCFullYear(),
				hours = o.getUTCHours(),
				minutes = o.getUTCMinutes(),
				seconds = o.getUTCSeconds(),
				milli = o.getUTCMilliseconds();

			if (month < 10) {
				month = '0' + month;
			}
			if (day < 10) {
				day = '0' + day;
			}
			if (hours < 10) {
				hours = '0' + hours;
			}
			if (minutes < 10) {
				minutes = '0' + minutes;
			}
			if (seconds < 10) {
				seconds = '0' + seconds;
			}
			if (milli < 100) {
				milli = '0' + milli;
			}
			if (milli < 10) {
				milli = '0' + milli;
			}
			return '"' + year + '-' + month + '-' + day + 'T' +
				hours + ':' + minutes + ':' + seconds +
				'.' + milli + 'Z"';
		}

		pairs = [];

		if ($.isArray(o)) {
			for (k = 0; k < o.length; k++) {
				pairs.push($.toJSON(o[k]) || 'null');
			}
			return '[' + pairs.join(',') + ']';
		}

		// Any other object (plain object, RegExp, ..)
		// Need to do typeof instead of $.type, because we also
		// want to catch non-plain objects.
		if (typeof o === 'object') {
			for (k in o) {
				// Only include own properties,
				// Filter out inherited prototypes
				if (hasOwn.call(o, k)) {
					// Keys must be numerical or string. Skip others
					type = typeof k;
					if (type === 'number') {
						name = '"' + k + '"';
					} else if (type === 'string') {
						name = $.quoteString(k);
					} else {
						continue;
					}
					type = typeof o[k];

					// Invalid values like these return undefined
					// from toJSON, however those object members
					// shouldn't be included in the JSON string at all.
					if (type !== 'function' && type !== 'undefined') {
						val = $.toJSON(o[k]);
						pairs.push(name + ':' + val);
					}
				}
			}
			return '{' + pairs.join(',') + '}';
		}
	};

	/**
	 * jQuery.evalJSON
	 * Evaluates a given json string.
	 *
	 * @param str {String}
	 */
	$.evalJSON = typeof JSON === 'object' && JSON.parse ? JSON.parse : function (str) {
		/*jshint evil: true */
		return eval('(' + str + ')');
	};

	/**
	 * jQuery.secureEvalJSON
	 * Evals JSON in a way that is *more* secure.
	 *
	 * @param str {String}
	 */
	$.secureEvalJSON = typeof JSON === 'object' && JSON.parse ? JSON.parse : function (str) {
		var filtered =
			str
			.replace(/\\["\\\/bfnrtu]/g, '@')
			.replace(/"[^"\\\n\r]*"|true|false|null|-?\d+(?:\.\d*)?(?:[eE][+\-]?\d+)?/g, ']')
			.replace(/(?:^|:|,)(?:\s*\[)+/g, '');

		if (/^[\],:{}\s]*$/.test(filtered)) {
			/*jshint evil: true */
			return eval('(' + str + ')');
		}
		throw new SyntaxError('Error parsing JSON, source is not valid.');
	};

	/**
	 * jQuery.quoteString
	 * Returns a string-repr of a string, escaping quotes intelligently.
	 * Mostly a support function for toJSON.
	 * Examples:
	 * >>> jQuery.quoteString('apple')
	 * "apple"
	 *
	 * >>> jQuery.quoteString('"Where are we going?", she asked.')
	 * "\"Where are we going?\", she asked."
	 */
	$.quoteString = function (str) {
		if (str.match(escape)) {
			return '"' + str.replace(escape, function (a) {
				var c = meta[a];
				if (typeof c === 'string') {
					return c;
				}
				c = a.charCodeAt();
				return '\\u00' + Math.floor(c / 16).toString(16) + (c % 16).toString(16);
			}) + '"';
		}
		return '"' + str + '"';
	};

}(jQuery));
/*!
 * JavaScript Cookie v2.1.3
 * https://github.com/js-cookie/js-cookie
 *
 * Copyright 2006, 2015 Klaus Hartl & Fagner Brack
 * Released under the MIT license
 */
;(function (factory) {
	var registeredInModuleLoader = false;
	if (typeof define === 'function' && define.amd) {
		define(factory);
		registeredInModuleLoader = true;
	}
	if (typeof exports === 'object') {
		module.exports = factory();
		registeredInModuleLoader = true;
	}
	if (!registeredInModuleLoader) {
		var OldCookies = window.Cookies;
		var api = window.Cookies = factory();
		api.noConflict = function () {
			window.Cookies = OldCookies;
			return api;
		};
	}
}(function () {
	function extend () {
		var i = 0;
		var result = {};
		for (; i < arguments.length; i++) {
			var attributes = arguments[ i ];
			for (var key in attributes) {
				result[key] = attributes[key];
			}
		}
		return result;
	}

	function init (converter) {
		function api (key, value, attributes) {
			var result;
			if (typeof document === 'undefined') {
				return;
			}

			// Write

			if (arguments.length > 1) {
				attributes = extend({
					path: '/'
				}, api.defaults, attributes);

				if (typeof attributes.expires === 'number') {
					var expires = new Date();
					expires.setMilliseconds(expires.getMilliseconds() + attributes.expires * 864e+5);
					attributes.expires = expires;
				}

				try {
					result = JSON.stringify(value);
					if (/^[\{\[]/.test(result)) {
						value = result;
					}
				} catch (e) {}

				if (!converter.write) {
					value = encodeURIComponent(String(value))
						.replace(/%(23|24|26|2B|3A|3C|3E|3D|2F|3F|40|5B|5D|5E|60|7B|7D|7C)/g, decodeURIComponent);
				} else {
					value = converter.write(value, key);
				}

				key = encodeURIComponent(String(key));
				key = key.replace(/%(23|24|26|2B|5E|60|7C)/g, decodeURIComponent);
				key = key.replace(/[\(\)]/g, escape);

				return (document.cookie = [
					key, '=', value,
					attributes.expires ? '; expires=' + attributes.expires.toUTCString() : '', // use expires attribute, max-age is not supported by IE
					attributes.path ? '; path=' + attributes.path : '',
					attributes.domain ? '; domain=' + attributes.domain : '',
					attributes.secure ? '; secure' : ''
				].join(''));
			}

			// Read

			if (!key) {
				result = {};
			}

			// To prevent the for loop in the first place assign an empty array
			// in case there are no cookies at all. Also prevents odd result when
			// calling "get()"
			var cookies = document.cookie ? document.cookie.split('; ') : [];
			var rdecode = /(%[0-9A-Z]{2})+/g;
			var i = 0;

			for (; i < cookies.length; i++) {
				var parts = cookies[i].split('=');
				var cookie = parts.slice(1).join('=');

				if (cookie.charAt(0) === '"') {
					cookie = cookie.slice(1, -1);
				}

				try {
					var name = parts[0].replace(rdecode, decodeURIComponent);
					cookie = converter.read ?
						converter.read(cookie, name) : converter(cookie, name) ||
						cookie.replace(rdecode, decodeURIComponent);

					if (this.json) {
						try {
							cookie = JSON.parse(cookie);
						} catch (e) {}
					}

					if (key === name) {
						result = cookie;
						break;
					}

					if (!key) {
						result[name] = cookie;
					}
				} catch (e) {}
			}

			return result;
		}

		api.set = api;
		api.get = function (key) {
			return api.call(api, key);
		};
		api.getJSON = function () {
			return api.apply({
				json: true
			}, [].slice.call(arguments));
		};
		api.defaults = {};

		api.remove = function (key, attributes) {
			api(key, '', extend(attributes, {
				expires: -1
			}));
		};

		api.withConverter = init;

		return api;
	}

	return init(function () {});
}));

jQuery.fn.populate2 = function(obj, options) {
	
	
	// ------------------------------------------------------------------------------------------
	// JSON conversion function
	
		// convert 
			function parseJSON(obj, path)
			{
				// prepare
					path = path || '';
				
				// iteration (objects / arrays)
					if(obj == undefined)
					{
						// do nothing
					}
					else if(obj.constructor == Object)
					{
						for(var prop in obj)
						{
							var name	= path + (path == '' ? prop : '[' +prop+ ']');
							parseJSON(obj[prop], name);
						}
					}
						
					else if(obj.constructor == Array)
					{
						for(var i = 0; i < obj.length; i++)
						{
							var index	= options.phpIndices ? i : '';
							index		= options.phpNaming ? '[' +index+']' : index;
							var name	= path + index;
							parseJSON(obj[i], name);
						}
					}
					
				// assignment (values)
					else
					{
						// if the element name hasn't yet been defined, create it as a single value
						if(arr[path] == undefined)
						{
							arr[path] = obj;
						}
		
						// if the element name HAS been defined, but it's a single value, convert to an array and add the new value
						else if(arr[path].constructor != Array)
						{
							arr[path] = [arr[path], obj];
						}
							
						// if the element name HAS been defined, and is already an array, push the single value on the end of the stack
						else
						{
							arr[path].push(obj);
						}
					}
	
			};


	// ------------------------------------------------------------------------------------------
	// population functions
		
		function debug(str)
		{
			if(window.console && console.log)
			{
				console.log(str);
			}
		}
		
		function getElementName(name)
		{
			if (!options.phpNaming)
			{
				name = name.replace(/\[\]$/,'');
			}
			return name;
		}
		
		function populateElement(parentElement, name, value)
		{
			var selector	= options.identifier == 'id' ? '#' + name : '[' +options.identifier+ '="' +name+ '"]';
			var jel=jQuery(selector, parentElement);
			if(jel.size()==0) return;
			var element		= jel.get();
			
			
			
			if(options.debug)
			{
				_populate.elements.push(element);
			}
			
		// now, place any single elements in an array.
		// this is so that the next bit of code (a loop) can treat them the 
		// same as any array-elements passed, ie radiobutton or checkox arrays,
		// and the code will just work

			elements = element.type == undefined && element.length ? element : [element];
			
			
		// populate the element correctly
		
			for(var e = 0; e < elements.length; e++)
			{
				
			// grab the element
				var element = elements[e];
				
			// skip undefined elements or function objects (IE only)
				if(!element || typeof element == 'undefined' || typeof element == 'function')
				{
					continue;
				}
				
			// anything else, process
				switch(element.type || element.tagName)
				{

					case 'radio':
						// use the single value to check the radio button
						element.checked = (element.value != '' && value.toString() == element.value);
						
					case 'checkbox':
						// depends on the value.
						// if it's an array, perform a sub loop
						// if it's a value, just do the check
						
						var values = value.constructor == Array ? value : [value];
						for(var j = 0; j < values.length; j++)
						{
							element.checked |= element.value == values[j];
						}
						
						//element.checked = (element.value != '' && value.toString().toLowerCase() == element.value.toLowerCase());
						break;
						
					case 'select-multiple':
						var values = value.constructor == Array ? value : [value];
						for(var i = 0; i < element.options.length; i++)
						{
							for(var j = 0; j < values.length; j++)
							{
								element.options[i].selected |= element.options[i].value == values[j];
							}
						}
						break;
					
					case 'select':
					case 'select-one':
						element.value = value.toString() || value;
						break;

					case 'text':
					case 'hidden':
					case 'button':
					case 'textarea':
				
					case 'submit':
						value			= value == null ? '' : value;
						element.value	= value;
						break;
					case 'file':
						break;
					default:

						value			= value.toString();
						value			= value == 'null' ? '' : value;
						jel.html(value);
						
				}
					
			}
			
		}
		
		function populateFormElement(form, name, value)
		{

			// check that the named element exists in the form
				var name	= getElementName(name); // handle non-php naming
				var element	= form[name];
				
			// if the form element doesn't exist, check if there is a tag with that id
				if(element == undefined)
				{
					// look for the element
						element = jQuery('#' + name, form);
						if(element)
						{
							element.html(value);
							return true;
						}
					
					// nope, so exit
						if(options.debug)
						{
							debug('No such element as ' + name);
						}
						return false;
				}
					
			// debug options				
				if(options.debug)
				{
					_populate.elements.push(element);
				}
				
			// now, place any single elements in an array.
			// this is so that the next bit of code (a loop) can treat them the 
			// same as any array-elements passed, ie radiobutton or checkox arrays,
			// and the code will just work

				elements = element.type == undefined && element.length ? element : [element];
				
				
			// populate the element correctly
			
				for(var e = 0; e < elements.length; e++)
				{
					
				// grab the element
					var element = elements[e];
					
				// skip undefined elements or function objects (IE only)
					if(!element || typeof element == 'undefined' || typeof element == 'function')
					{
						continue;
					}
					
				// anything else, process
					switch(element.type || element.tagName)
					{
	
						case 'radio':
							// use the single value to check the radio button
							element.checked = (element.value != '' && value.toString() == element.value);
							
						case 'checkbox':
							// depends on the value.
							// if it's an array, perform a sub loop
							// if it's a value, just do the check
							
							var values = value.constructor == Array ? value : [value];
							for(var j = 0; j < values.length; j++)
							{
								element.checked |= element.value == values[j];
							}
							
							//element.checked = (element.value != '' && value.toString().toLowerCase() == element.value.toLowerCase());
							break;
							
						case 'select-multiple':
							var values = value.constructor == Array ? value : [value];
							for(var i = 0; i < element.options.length; i++)
							{
								for(var j = 0; j < values.length; j++)
								{
									element.options[i].selected |= element.options[i].value == values[j];
								}
							}
							break;
						
						case 'select':
						case 'select-one':
							element.value = value.toString() || value;
							break;
	
						case 'text':
						case 'button':
						case 'textarea':
						case 'submit':
						default:
							value			= value == null ? '' : value;
							element.value	= value;
							
					}
						
				}

		}
		

		
	// ------------------------------------------------------------------------------------------
	// options & setup
		
		// exit if no data object supplied
			if (obj === undefined)
			{
				return this;
			};
		
		// options
			var options = jQuery.extend
			(
				{
					phpNaming:			false,
					phpIndices:			false,
					resetForm:			true,
					identifier:			'name',
					debug:				false
				},
				options
			);
				
			if(options.phpIndices)
			{
				options.phpNaming = true;
			}
	
	// ------------------------------------------------------------------------------------------
	// convert hierarchical JSON to flat array
		
			var arr	= [];
			parseJSON(obj);
			
			if(options.debug)
			{
				_populate =
				{
					arr:		arr,
					obj:		obj,
					elements:	[]
				}
			}
	
	// ------------------------------------------------------------------------------------------
	// main process function
		
		this.each
		(
			function()
			{
				
				// variables
					var tagName	= this.tagName.toLowerCase();
				//	var method	= tagName == 'form' ? populateFormElement : populateElement;
					var method	=  populateElement;
					
				// reset form?
					if(tagName == 'form' && options.resetForm)
					{
						this.reset();
					}

				// update elements
					for(var i in arr)
					{
						method(this, i, arr[i]);
					}
			}
			
		);

return this;
};﻿/*
 * jQuery showLoading plugin v1.0
 * 
 * Copyright (c) 2009 Jim Keller
 * Context - http://www.contextllc.com
 * 
 * Dual licensed under the MIT and GPL licenses.
 *
 */

	jQuery.fn.showLoading = function(options) {
		
		var indicatorID;
       		var settings = {
       			'addClass': '',
	       		'beforeShow': '', 
       			'afterShow': '',
       			'hPos': 'center', 
	       		'vPos': 'center',
       			'indicatorZIndex' : 95001, 
       			'overlayZIndex': 95000, 
	       		'parent': '',
       			'marginTop': 0,
       			'marginLeft': 0,
	       		'overlayWidth': null,
       			'overlayHeight': null
	       	};

        jQuery(this).addClass("loading-indicator-overlay-position");
		jQuery.extend(settings, options);
       	
       	var loadingDiv = jQuery('<div></div>');
		var overlayDiv = jQuery('<div></div>');

		//
		// Set up ID and classes
		//
		if ( settings.indicatorID ) {
			indicatorID = settings.indicatorID;
		}
		else {
			indicatorID = jQuery(this).attr('id');
		}
			
		jQuery(loadingDiv).attr('id', 'loading-indicator-' + indicatorID );
		jQuery(loadingDiv).addClass('loading-indicator');
		
		if ( settings.addClass ){
			jQuery(loadingDiv).addClass(settings.addClass);
		}


		
		//
		// Create the overlay
		//
		jQuery(overlayDiv).css('display', 'none');
		
		var parent=settings.parent||this;
		// Append to body, otherwise position() doesn't work on Webkit-based browsers
		 jQuery(parent).append(overlayDiv);
		
		//
		// Set overlay classes
		//
		jQuery(overlayDiv).attr('id', 'loading-indicator-' + indicatorID + '-overlay');
		
		jQuery(overlayDiv).addClass('loading-indicator-overlay');
		
		if ( settings.addClass ){
			jQuery(overlayDiv).addClass(settings.addClass + '-overlay');
		}
		
		//
		// Set overlay position
		//
		
		var overlay_width;
		var overlay_height;
		
		var border_top_width = jQuery(this).css('border-top-width');
		var border_left_width = jQuery(this).css('border-left-width');
		
		//
		// IE will return values like 'medium' as the default border, 
		// but we need a number
		//
		border_top_width = isNaN(parseInt(border_top_width)) ? 0 : border_top_width;
		border_left_width = isNaN(parseInt(border_left_width)) ? 0 : border_left_width;
		
		var overlay_left_pos = 0+ parseInt(border_left_width);//jQuery(this).offset().left + parseInt(border_left_width);
		var overlay_top_pos = 0+ parseInt(border_top_width);//jQuery(this).offset().top + parseInt(border_top_width);
		
		if ( settings.overlayWidth !== null ) {
			overlay_width = settings.overlayWidth;
		}
		else {
			overlay_width = parseInt(jQuery(this).width()) + parseInt(jQuery(this).css('padding-right')) + parseInt(jQuery(this).css('padding-left'));
		}

		if ( settings.overlayHeight !== null ) {
			overlay_height = settings.overlayWidth;
		}
		else {
			overlay_height = parseInt(jQuery(this).height()) + parseInt(jQuery(this).css('padding-top')) + parseInt(jQuery(this).css('padding-bottom'));
		}

		
		jQuery(overlayDiv).css('width', overlay_width.toString() + 'px');
		jQuery(overlayDiv).css('height', overlay_height.toString() + 'px');

		jQuery(overlayDiv).css('left', overlay_left_pos.toString() + 'px');
		jQuery(overlayDiv).css('position', 'absolute');

		jQuery(overlayDiv).css('top', overlay_top_pos.toString() + 'px' );
		jQuery(overlayDiv).css('z-index', settings.overlayZIndex);

		//
		// Set any custom overlay CSS		
		//
       		if ( settings.overlayCSS ) {
       			jQuery(overlayDiv).css ( settings.overlayCSS );
       		}


		//
		// We have to append the element to the body first
		// or .width() won't work in Webkit-based browsers (e.g. Chrome, Safari)
		//
		jQuery(loadingDiv).css('display', 'none');
		jQuery(parent).append(loadingDiv);
		
		jQuery(loadingDiv).css('position', 'absolute');
		jQuery(loadingDiv).css('z-index', settings.indicatorZIndex);

		//
		// Set top margin
		//

		var indicatorTop = overlay_top_pos;
		
		if ( settings.marginTop ) {
			indicatorTop += parseInt(settings.marginTop);
		}
		
		var indicatorLeft = overlay_left_pos;
		
		if ( settings.marginLeft ) {
			indicatorLeft += parseInt(settings.marginTop);
		}
		
		
		//
		// set horizontal position
		//
		if ( settings.hPos.toString().toLowerCase() == 'center' ) {
			jQuery(loadingDiv).css('left', (indicatorLeft + ((jQuery(overlayDiv).width() - parseInt(jQuery(loadingDiv).width())) / 2)).toString()  + 'px');
		}
		else if ( settings.hPos.toString().toLowerCase() == 'left' ) {
			jQuery(loadingDiv).css('left', (indicatorLeft + parseInt(jQuery(overlayDiv).css('margin-left'))).toString() + 'px');
		}
		else if ( settings.hPos.toString().toLowerCase() == 'right' ) {
			jQuery(loadingDiv).css('left', (indicatorLeft + (jQuery(overlayDiv).width() - parseInt(jQuery(loadingDiv).width()))).toString()  + 'px');
		}
		else {
			jQuery(loadingDiv).css('left', (indicatorLeft + parseInt(settings.hPos)).toString() + 'px');
		}		

		//
		// set vertical position
		//
		if ( settings.vPos.toString().toLowerCase() == 'center' ) {
			jQuery(loadingDiv).css('top', (indicatorTop + ((jQuery(overlayDiv).height() - parseInt(jQuery(loadingDiv).height())) / 2)).toString()  + 'px');
		}
		else if ( settings.vPos.toString().toLowerCase() == 'top' ) {
			jQuery(loadingDiv).css('top', indicatorTop.toString() + 'px');
		}
		else if ( settings.vPos.toString().toLowerCase() == 'bottom' ) {
			jQuery(loadingDiv).css('top', (indicatorTop + (jQuery(overlayDiv).height() - parseInt(jQuery(loadingDiv).height()))).toString()  + 'px');
		}
		else {
			jQuery(loadingDiv).css('top', (indicatorTop + parseInt(settings.vPos)).toString() + 'px' );
		}		


		 
		
		//
		// Set any custom css for loading indicator
		//
       		if ( settings.css ) {
       			jQuery(loadingDiv).css ( settings.css );
       		}

		
		//
		// Set up callback options
		//
		var callback_options = 
			{
				'overlay': overlayDiv,
				'indicator': loadingDiv,
				'element': this
			};
	
		//
		// beforeShow callback
		//
		if ( typeof(settings.beforeShow) == 'function' ) {
			settings.beforeShow( callback_options );
		}
		
		//
		// Show the overlay
		//
		jQuery(overlayDiv).show();
		
		//
		// Show the loading indicator
		//
		jQuery(loadingDiv).show();

		//
		// afterShow callback
		//
		if ( typeof(settings.afterShow) == 'function' ) {
			settings.afterShow( callback_options );
		}

		return this;
    	 };


	jQuery.fn.hideLoading = function(options) {
		
		
       		var settings = {};
	
       		jQuery.extend(settings, options);
       		var parent=settings.parent||this;
		if ( settings.indicatorID ) {
			indicatorID = settings.indicatorID;
		}
		else {
			indicatorID = jQuery(this).attr('id');
		}
		jQuery(this).removeClass("loading-indicator-overlay-position");
   		jQuery(parent).find('#loading-indicator-' + indicatorID ).remove();
		jQuery(parent).find('#loading-indicator-' + indicatorID + '-overlay' ).remove();
		
		return this;
     	};
/****
定义命名空间
用法如下：
$.namespace('easyui.ext');

easyui.ext.xxx=function(){

}
***/
(function($){
 	$.extend({
 		namespace: function(ns){
 			if(typeof ns != 'string'){
 				throw new Error('namespace must be a string');
 			}
 			
 			var ns_arr = ns.split('.');
 			var parent = window;
 			for(var i in ns_arr){
 				parent[ns_arr[i]] = parent[ns_arr[i]] || {};
 				parent = parent[ns_arr[i]];
 			}
 		}
 	});
 })(jQuery);
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
		contentType : "application/x-www-form-urlencoded;charset=utf-8",
		timeout : 1000*60*5
	});
	/**
	 * 解决ajax重复提交的问题,此处可以全局作缓存
	 */
	var pendingRequests = {};
    jQuery.ajaxPrefilter(function( options, originalOptions, jqXHR ) {
    	/*
        var key = options.url;
        if (!pendingRequests[key]) {
            pendingRequests[key] = jqXHR;
        }else{
            jqXHR.abort();    //放弃后触发的提交
            //pendingRequests[key].abort();   // 放弃先触发的提交
        }
		*/
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
			if (sessionstatus == "timeout") {
				// 如果超时就处理 ，指定要跳转的页面
				alert("你已经超时，请重新登陆！");
				var xmlDoc=XMLHttpRequest.responseText;
				var ret=eval('(' + xmlDoc + ')');//$.evalJSON(xmlDoc);
				if(window.top){
					window.top.location=ret.login;
				}else{
					window.location=ret.login;
				}
			}
		}
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
			modal:false
			
		});
		if($.messager.show){
			var show=$.messager.show;
			$.messager.show=function(options){
				if(!options.timeout ){
					options.timeout=4000;
				}else{
					options.timeout=4000;
				}
				show(options);
			}
		};
		if($.messager.alert){
			var alert2=$.messager.alert;
			$.messager.alert=function(title, msg, icon, fn){
				if(!icon || icon==""){
					icon="info";
				}
				alert2(title, msg, icon, fn);
			}
		};
		
		
		
		if($.messager.confirm){
			var confirm2=$.messager.confirm;
			$.messager.confirm=function(title, msg, fn){
				confirm2({'title':title,'msg':msg,'fn':fn,'ok':'是','cancel':'否'});
			}
		}
		
		if ($.messager){
			//$.messager.defaults.ok = '是';
			//$.messager.defaults.cancel = '否';
		}
	}
	/***改写默认控件的高度***/
	var my_default_height=30;
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
		//$.fn.combo.defaults.panelHeight=100;
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
				return /^(13|15|18)\d{9}$/i.test(value);
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
		currency : {// 验证货币
			validator : function(value) {
				return /^\d+(\.\d+)?$/i.test(value);
			},
			message : '货币格式不正确'
		},
		qq : {// 验证QQ,从10000开始
			validator : function(value) {
				return /^[1-9]\d{4,9}$/i.test(value);
			},
			message : 'QQ号码格式不正确'
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
			validator : function(value,param) {
				return /^[a-zA-Z][a-zA-Z0-9_]{5,15}$/i.test(value);
			},
			message : '{0}不合法（字母开头，允许6-16字节，允许字母数字下划线）'
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
	 					var ch2=0;//$(iframe.get(0)).contents().find("html")[0].scrollHeight;
	 					var ch3=$($(iframe.get(0)).contents().find("body")[0]).height();
	 					
	 					ch1=Math.min(ch1,ch3);
	 					if(options.autoHeight){
	 					  //$(iframe.get(0)).contents().find("body").css("overflow","hidden");
	 					}
	 					var titleHeight=win.dialog("header").height()+10;
	 					
	 					var ch= Math.max(ch1, ch2)+titleHeight;
	 					//alert(ch);
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

	 $(target).find(".validatebox-invalid").removeClass('validatebox-invalid');
	 $(target).find(".textbox-invalid").removeClass('textbox-invalid');
	 $(target).find("input").blur();

 }
 
 function addEasyUiInvalidTip(target){
	 var target=$(target).next("span").addClass("textbox-invalid");
	 target.find(".validatebox-text").addClass('validatebox-invalid');

 }
 

 ﻿/**
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


/**jquery扩展****/
if(jQuery){
	
	/**
	 * 序列化元素下的input元素，生成key-value的json对象
	 */
	jQuery.fn.serializeObject = function() {
		var o = {};
		var a = this.serializeArray();
		$.each(a, function() {
			if (o[this.name]) {
				if (!o[this.name].push) {
					o[this.name] = [ o[this.name] ];
				}
				o[this.name].push(this.value || '');
			} else {
				o[this.name] = this.value || '';
			}
		});
		return o;
	};
}
/*******/
//This function creates a new anchor element and uses location
//properties (inherent) to get the desired URL data. Some String
//operations are used (to normalize results across browsers).
/*
 var myURL = parseURL('http://abc.com:8080/dir/index.html?id=255&m=hello#top');

 myURL.file;     // = 'index.html'
 myURL.hash;     // = 'top'
 myURL.host;     // = 'abc.com'
 myURL.query;    // = '?id=255&m=hello'
 myURL.params;   // = Object = { id: 255, m: hello }
 myURL.path;     // = '/dir/index.html'
 myURL.segments; // = Array = ['dir', 'index.html']
 myURL.port;     // = '8080'
 myURL.protocol; // = 'http'
 myURL.source;   // = 'http://abc.com:8080/dir/index.html?id=255&m=hello#top'
 */
function parseURL(url) {
	var a = document.createElement('a');
	a.href = url;
	return {
		source : url, 
		protocol : a.protocol.replace(':', ''),
		host : a.hostname,
		port : a.port,
		query : a.search,
		params : (function() {
			var ret = {}, seg = a.search.replace(/^\?/, '').split('&'), len = seg.length, i = 0, s;
			for (; i < len; i++) {
				if (!seg[i]) {
					continue;
				}
				s = seg[i].split('=');
				ret[s[0]] = decodeURIComponent(s[1]);
			}
			return ret;
		})(),
		file : (a.pathname.match(/\/([^\/?#]+)$/i) || [ , '' ])[1],
		hash : a.hash.replace('#', ''),
		path : a.pathname.replace(/^([^\/])/, '/$1'),
		relative : (a.href.match(/tps?:\/\/[^\/]+(.+)/) || [ , '' ])[1],
		segments : a.pathname.replace(/^\//, '').split('/')
	};
}
function getMiddlePosition(iHeight, iWidth){
	var iTop = ($(window).height() - 60 - iHeight) / 2; //获得窗口的垂直位置;
	var iLeft = ($(window).width() - 20 - iWidth) / 2; //获得窗口的水平位置;
	var position={};
	position.left=iLeft;
	position.top=iTop;
	return position;
}
function openWindow(url, name, iWidth, iHeight) {

	var iTop = (window.screen.availHeight - 30 - iHeight) / 2; //获得窗口的垂直位置;
	var iLeft = (window.screen.availWidth - 10 - iWidth) / 2; //获得窗口的水平位置;
	//alert("ddd")
	var win = window
			.open(
					url,
					name,
					'height='
							+ iHeight
							+ ',width='
							+ iWidth
							+ ',top='
							+ iTop
							+ ',left='
							+ iLeft
							+ ',menubar=no,scrollbars=no,resizable=no,status=no,toolbar=no ,location=no');
	win.focus();

	return win;
}

function fillsize(percent){
	var bodyWidth = document.body.clientWidth;
	return (bodyWidth-90)*percent;
}



function debuglog(msg){
	console.log(msg);
}

//格式化货币值
function formatCurrency(num) {
	num = num.toString().replace(/\$|\,/g,'');
	if(isNaN(num))
	num = "0";
	sign = (num == (num = Math.abs(num)));
	num = Math.floor(num*100+0.50000000001);
	cents = num%100;
	num = Math.floor(num/100).toString();
	if(cents<10)
	cents = "0" + cents;
	for (var i = 0; i < Math.floor((num.length-(1+i))/3); i++)
	num = num.substring(0,num.length-(4*i+3))+','+
	num.substring(num.length-(4*i+3));
	return (((sign)?'':'-') + '￥' + num + '.' + cents);
	}

//格式化货币值
function formatRemoteCurrency(num) {
	num = num.toString().replace(/\$|\,/g,'');
	if(isNaN(num))
	num = "0";
	sign = (num == (num = Math.abs(num)));
	num = Math.floor(num*100+0.50000000001);
	cents = num%100;
	num = Math.floor(num/100).toString();
	if(cents<10)
	cents = "0" + cents;
	for (var i = 0; i < Math.floor((num.length-(1+i))/3); i++)
	num = num.substring(0,num.length-(4*i+3))+','+
	num.substring(num.length-(4*i+3));
	return (((sign)?'':'-') + num + '.' + cents);
	}



function syncGet(url){
	var ret = '';
	$.ajax({
    	dataType: 'text',
    	type: 'GET',
    	async: false,
    	cache: false,
    	url: url,
    	success: function(data){
    		ret=data;
    	},
    	error: function(){
    		$.messager.alert("提示", "获取数据错误!!");
    	}
    });
	return ret;
}

function syncPostJSON(url,postData){
	var ret = null;
	$.ajax({
    	dataType: 'text',
    	type: 'POST',
    	async: false,
    	data: postData,
    	cache: false,
    	url: url,
    	success: function(data){
    		ret = $.evalJSON($.trim(data));
    	},
    	error: function(){
    		$.messager.alert("提示", "获取数据错误!!");
    	}
    });
	return ret;
};
function syncGetJSON(url){
	var ret = null;
	$.ajax({
    	dataType: 'text',
    	type: 'GET',
    	async: false,
    	cache: false,
    	url: url,
    	success: function(data){
    		ret = $.evalJSON($.trim(data));
    	},
    	error: function(){
    		$.messager.alert("提示", "获取数据错误!!");
    	}
    });
	return ret;
};

function syncPost(url,postData){
	var ret = '';
	$.ajax({
    	dataType: 'text',
    	type: 'POST',
    	async: false,
    	data: postData,
    	cache: false,
    	url: url,
    	success: function(data){
    		//ret = $.evalJSON($.trim(data));
    		ret=data;
    	},
    	error: function(){
    		$.messager.alert("提示", "获取数据错误!!");
    	}
    });
	return ret;
};
/**
 * 
 * @param url
 * @param fun ：格式为 function(data){...}
 * @returns {String}
 */
function asynGet(url,fun){
	$.ajax({
    	dataType: 'text',
    	type: 'GET',
    	async: true,
    	cache: false,
    	url: url,
    	success: fun,
    	error: function(){
    		$.messager.alert("提示", "获取数据错误!!");
    	}
    });
}

/**
 * 
 * @param url
 * @param fun ：格式为 function(data){...}
 * @returns {String}
 */
function asynPost(url,fun){
	$.ajax({
    	dataType: 'text',
    	type: 'POST',
    	async: true,
    	cache: false,
    	url: url,
    	success: fun,
    	error: function(){
    		$.messager.alert("提示", "获取数据错误!!");
    	}
    });
}

/**
 * 
 * @param url
 * @params:参数格式{"base_code":''}
 * @param fun ：格式为 function(data){...}
 * @returns {String}
 */
function asynPostParam(URL,params,fun){
	$.ajax({
    	dataType: 'text',
    	type: 'POST',
    	async: true,
    	cache: false,
    	url: URL,
    	data:params,
    	success: fun,
    	error: function(){
    		$.messager.alert("提示", "获取数据错误!!");
    	}
    });
}

String.prototype.replaceAll = function(s1,s2){   
    return this.replace(new RegExp(s1,"gm"),s2);   
};

String.prototype.endWith=function(s){
	  if(s==null||s==""||this.length==0||s.length>this.length)
	     return false;
	  if(this.substring(this.length-s.length)==s)
	     return true;
	  else
	     return false;
	  return true;
	 };
 String.prototype.startWith=function(s){
	  if(s==null||s==""||this.length==0||s.length>this.length)
	   return false;
	  if(this.substr(0,s.length)==s)
	     return true;
	  else
	     return false;
	  return true;
};
function isInteger(obj) {
	 return typeof obj === 'number' && obj%1 === 0
}
function arrayStrToInt(array){
	if(array!=null && array.length>0){
		for(var i=0; i<array.length; i++){
		   var v=parseInt(array[i]);
		   if(isInteger(v) ){
			   array[i] =v;
		   }else{
			   array[i] =null;
		   }
		}
		return array;
	}else{
		return [];
	}
}

function arrayIntToStr(array){
	if(array!=null && array.length>0){
		for(var i=0; i<array.length; i++){
		   var v=array[i]+"";
		   array[i] =v;
		}
		return array;
	}else{
		return [];
	}
}

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

 /**获得日期部分*/
function DateGetPart(dateStr){
	var value=$.trim(dateStr);
	if(value.length>10) {
		value=value.substring(0,10);
	}
	return value;
}

/**
 * 对json对象格式化输出，输出的格式比较美观
 * 用法 ：format_str = JsonUti.convertToString(jsonObj); 
 */
var JsonUti = {
	    //定义换行符
	    n: "\n",
	    //定义制表符
	    t: "   ",
	    //转换String
	    convertToString: function(obj) {
	        return JsonUti.__writeObj(obj, 1);
	    },
	    //写对象
	    __writeObj: function(obj //对象
	    , level //层次（基数为1）
	    , isInArray) { //此对象是否在一个集合内
	        //如果为空，直接输出null
	        if (obj == null) {
	            return "null";
	        }
	        //为普通类型，直接输出值
	        if (obj.constructor == Number || obj.constructor == Date || obj.constructor == String || obj.constructor == Boolean) {
	            var v = obj.toString();
	            var tab = isInArray ? JsonUti.__repeatStr(JsonUti.t, level - 1) : "";
	            if (obj.constructor == String || obj.constructor == Date) {
	                //时间格式化只是单纯输出字符串，而不是Date对象
	                return tab + ("\"" + v + "\"");
	            }
	            else if (obj.constructor == Boolean) {
	                return tab + v.toLowerCase();
	            }
	            else {
	                return tab + (v);
	            }
	        }
	        //写Json对象，缓存字符串
	        var currentObjStrings = [];
	        //遍历属性
	        for (var name in obj) {
	            var temp = [];
	            //格式化Tab
	            var paddingTab = JsonUti.__repeatStr(JsonUti.t, level);
	            temp.push(paddingTab);
	            //写出属性名
	            temp.push(name + " : ");
	            var val = obj[name];
	            if (val == null) {
	                temp.push("null");
	            }
	            else {
	                var c = val.constructor;
	                if (c == Array) { //如果为集合，循环内部对象
	                    temp.push(JsonUti.n + paddingTab + "[" + JsonUti.n);
	                    var levelUp = level + 2; //层级+2
	                    var tempArrValue = []; //集合元素相关字符串缓存片段
	                    for (var i = 0; i < val.length; i++) {
	                        //递归写对象
	                        tempArrValue.push(JsonUti.__writeObj(val[i], levelUp, true));
	                    }
	                    temp.push(tempArrValue.join("," + JsonUti.n));
	                    temp.push(JsonUti.n + paddingTab + "]");
	                }
	                else if (c == Function) {
	                    temp.push("[Function]");
	                }
	                else {
	                    //递归写对象
	                    temp.push(JsonUti.__writeObj(val, level + 1));
	                }
	            }
	            //加入当前对象“属性”字符串
	            currentObjStrings.push(temp.join(""));
	        }
	        return (level > 1 && !isInArray ? JsonUti.n: "") //如果Json对象是内部，就要换行格式化
	        + JsonUti.__repeatStr(JsonUti.t, level - 1) + "{" + JsonUti.n //加层次Tab格式化
	        + currentObjStrings.join("," + JsonUti.n) //串联所有属性值
	        + JsonUti.n + JsonUti.__repeatStr(JsonUti.t, level - 1) + "}"; //封闭对象
	    },
	    __isArray: function(obj) {
	        if (obj) {
	            return obj.constructor == Array;
	        }
	        return false;
	    },
	    __repeatStr: function(str, times) {
	        var newStr = [];
	        if (times > 0) {
	            for (var i = 0; i < times; i++) {
	                newStr.push(str);
	            }
	        }
	        return newStr.join("");
	    }
	};



/**
 * 判断是否为数组类型
 * @returns {String}
 */
function isArray(obj){
	 if(typeof obj=="object"&&obj.constructor==Array){
		 return true;
	 }
	 return false;
} 

function getDate(date){
	var myDate
	if(date){
		myDate=date;
	}else{
		myDate = new Date();
	}
	
	var year = myDate.getFullYear()+"";
	var month = myDate.getMonth();
	month = month+1;
	month = month+"";
	if(month.length==1){
		month = "0"+month;
	}
	var day = myDate.getDate();
	day = day+"";
	if(day.length==1){
		day = "0"+day;
	}
	return year+"-"+month+"-"+day;
}
function getMonthDay(date){
	var myDate
	if(date){
		myDate=date;
	}else{
		myDate = new Date();
	}
	var year = myDate.getFullYear()+"";
	var month = myDate.getMonth();
	month = month+1;
	month = month+"";
	if(month.length==1){
		month = "0"+month;
	}
	var day = myDate.getDate();
	day = day+"";
	if(day.length==1){
		day = "0"+day;
	}
	return month+"-"+day;
}

/**************
 var myurl=new MyURL.URL("http://www.baidu.com?a=1");
    
    myurl.set("b","hello"); //添加了b=hello
    alert (myurl.url());
    
    myurl.remove("b"); //删除了b
    
    alert(myurl.get ("a"));//取参数a的值，这里得到1
    
    myurl.set("a",23); //修改a的值为23
    
    alert (myurl.url());
 ****************/
var MyURL=(function(lg){
    var objURL=function(url){
        this.ourl=url||window.location.href;
        this.href="";//?前面部分
        this.params={};//url参数对象
        this.jing="";//#及后面部分
        this.init();
    }
    //分析url,得到?前面存入this.href,参数解析为this.params对象，#号及后面存入this.jing
    objURL.prototype.init=function(){
        var str=this.ourl;
        var index=str.indexOf("#");
        if(index>0){
            this.jing=str.substr(index);
            str=str.substring(0,index);
        }
        index=str.indexOf("?");
        if(index>0){
            this.href=str.substring(0,index);
            str=str.substr(index+1);
            var parts=str.split("&");
            for(var i=0;i<parts.length;i++){
                var kv=parts[i].split("=");
                var oldv=this.params[kv[0]];
                if(oldv!=null){
                	if(!isArray(oldv)){
                		oldv=[oldv];
                	}
                	oldv.push(kv[1]);
                }else{
                	oldv=kv[1];
                }
                this.params[kv[0]]=oldv;
            }
        }
        else{
            this.href=this.ourl;
            this.params={};
        }
    }
	    //只是修改this.params
    objURL.prototype.add=function(key,val){
		var oldv=this.params[key];;
		if(oldv!=null){
			if(!isArray(oldv)){
				oldv=[oldv];
			}
			if(isArray(val)){
				oldv=oldv.concat(val);
			}else{
				oldv.push(val);
			}
			
		}else{
			oldv=val;
		}
		this.params[key]=oldv;
    }
    //只是修改this.params
    objURL.prototype.set=function(key,val){
        this.params[key]=val;
    }
    //只是设置this.params
    objURL.prototype.remove=function(key){
        this.params[key]=undefined;
    }
    objURL.prototype.putAll=function(map){
    	for(var k in map){
    		if(map[k]){
	    		var v=map[k];
	    		this.add(k,v);
    		}
    	}
    }
    //根据三部分组成操作后的url
    objURL.prototype.url=function(){
        var strurl=this.href;
        var objps=[];//这里用数组组织,再做join操作
        for(var k in this.params){
            if(this.params[k]){
				if(isArray(this.params[k])){
					for(var j=0; j<this.params[k].length; j++){
						objps.push(k+"="+this.params[k][j]);
					}
				}else{
					objps.push(k+"="+this.params[k]);
				}
                
            }
        }
        if(objps.length>0){
            strurl+="?"+objps.join("&");
        }
        if(this.jing.length>0){
            strurl+=this.jing;
        }
        return strurl;
    }
    //得到参数值
    objURL.prototype.get=function(key){
        return this.params[key];
    }    
    lg.URL=objURL;
    return lg;
}(MyURL||{}));



/**
拷贝方法
src:源
isDeep:是否是深拷贝. true:是深拷贝  false：浅拷贝
**/
function myclone(src,isDeep){
	if(isDeep==undefined){
		isDeep=true;
	}
	return  $.extend( isDeep, {}, src );
}

function objToQueryStr(obj){
   return  $.param(obj,true);;
}

function stopBubble(e) { 
	//如果提供了事件对象，则这是一个非IE浏览器 
	if ( e && e.stopPropagation ) 
		//因此它支持W3C的stopPropagation()方法 
		e.stopPropagation(); 
	else 
		//否则，我们需要使用IE的方式来取消事件冒泡 
		window.event.cancelBubble = true; 
	
}

//阻止浏览器的默认行为
function stopDefault( e ) { //阻止默认浏览器动作(W3C) 
	if ( e && e.preventDefault ) e.preventDefault(); 
	//IE中阻止函数器默认动作的方式 
	else window.event.returnValue = false; 
	
	return false; 
}
	
	
/***********************************************************/
/**定义js对象的方法，例子使用如下*/
(function() {
    // 当前是否处于创建类的阶段
    var initializing = false;
    jClass = function() { }; //在全局window里定义了JClass
    jClass.extend = function(prop) {
        // 如果调用当前函数的对象（这里是函数）不是Class，则是父类
        var baseClass = null;
        if (this !== jClass) {
            baseClass = this;
        }
        // 本次调用所创建的类（构造函数）
        function F() {
            // 如果当前处于实例化类的阶段，则调用init原型函数
            if (!initializing) {
                // 如果父类存在，则实例对象的baseprototype指向父类的原型
                // 这就提供了在实例对象中调用父类方法的途径
                if (baseClass) {
                    this._superprototype = baseClass.prototype;
                }
                this.init.apply(this, arguments);
            }
        }
        // 如果此类需要从其它类扩展
        if (baseClass) {
            initializing = true;
            F.prototype = new baseClass();
            F.prototype.constructor = F;
            initializing = false;
        }
        // 新创建的类自动附加extend函数
        F.extend = arguments.callee;

        // 覆盖父类的同名函数
        for (var name in prop) {
            if (prop.hasOwnProperty(name)) {
                // 如果此类继承自父类baseClass并且父类原型中存在同名函数name
                if (baseClass &&
                typeof (prop[name]) === "function" &&
                typeof (F.prototype[name]) === "function" &&
                /\b_super\b/.test(prop[name])) {
                    // 重定义函数name - 
                    // 首先在函数上下文设置this._super指向父类原型中的同名函数
                    // 然后调用函数prop[name]，返回函数结果
                    // 注意：这里的自执行函数创建了一个上下文，这个上下文返回另一个函数，
                    // 此函数中可以应用此上下文中的变量，这就是闭包（Closure）。
                    // 这是JavaScript框架开发中常用的技巧。
                    F.prototype[name] = (function(name, fn) {
                        return function() {
                            this._super = baseClass.prototype[name];
                            return fn.apply(this, arguments);
                        };
                    })(name, prop[name]);
                } else {
                    F.prototype[name] = prop[name];
                }
            }
        }
        return F;
    };
})();
/**使用的例子
// 经过改造的jClass
var Person = jClass.extend({
    init: function(name) {
        this.name = name;
    },
    getName: function(prefix) {
        return prefix + this.name;
    }
});
var Employee = Person.extend({
    init: function(name, employeeID) {
        //  调用父类的方法
        this._super(name);
        this.employeeID = employeeID;
    },
    getEmployeeIDName: function() {
        // 注意：我们还可以通过这种方式调用父类中的其他函数
        var sname=this.getName(); //自身对象方法的调用
        var name = this._superprototype.getName.call(this, "Employee name: ");
        return name + ", Employee ID: " + this.employeeID;
    },
    getName: function() {
        //  调用父类的方法
        return this._super("Employee name: ");
    }
});

var zhang = new Employee("ZhangSan", "1234");
console.log(zhang.getName());   // "Employee name: ZhangSan"
console.log(zhang.getEmployeeIDName()); // "Employee name: ZhangSan, Employee ID: 1234"
**/

/****************************************************************/


/**
 * 生成uuid的函数
 */
function myuuid(len, radix) {
	var chars = '0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz'.split('');
	var uuid = [], i;
	radix = radix || chars.length;
 
	if (len) {
	  // Compact form
	  for (i = 0; i < len; i++) uuid[i] = chars[0 | Math.random()*radix];
	} else {
	  // rfc4122, version 4 form
	  var r;
 
	  // rfc4122 requires these characters
	  uuid[8] = uuid[13] = uuid[18] = uuid[23] = '-';
	  uuid[14] = '4';
 
	  // Fill in random data.  At i==19 set the high bits of clock sequence as
	  // per rfc4122, sec. 4.1.5
	  for (i = 0; i < 36; i++) {
		if (!uuid[i]) {
		  r = 0 | Math.random()*16;
		  uuid[i] = chars[(i == 19) ? (r & 0x3) | 0x8 : r];
		}
	  }
	}
	
	return 'u'+uuid.join('');
  }

/** 
* 获取浏览器版本 
*/  
/** 
 * 获取浏览器 
 */  
 function getMyBrowserType(){
    var userAgent = navigator.userAgent; //取得浏览器的userAgent字符串
   // alert(userAgent);
    var isOpera = userAgent.indexOf("Opera") > -1; //判断是否Opera浏览器
    var isIE = userAgent.indexOf("MSIE") > -1 ; //判断是否IE浏览器
    var isFF = userAgent.indexOf("Firefox") > -1; //判断是否Firefox浏览器
    var isSafari = userAgent.indexOf("Safari") > -1; //判断是否Safari浏览器
    var isChrome = userAgent.indexOf("Chrome") > -1; //判断Chrome浏览器
    var isEdge = userAgent.indexOf("Edge") > -1; //判断是否IE的Edge浏览器
    var isIE11 = (/Trident\/7\./).test(navigator.userAgent);
    var ret='';
    if(isIE)
    {
	    var reIE = new RegExp("MSIE (\\d+\\.\\d+);");
	    reIE.test(userAgent);
	    var fIEVersion = parseFloat(RegExp["$1"]);
	    if(fIEVersion == 7)
	    { ret= "ie7";}
	    else if(fIEVersion == 8)
	    { ret= "ie8";}
	    else if(fIEVersion == 9)
	    { ret= "ie9";}
	    else if(fIEVersion == 10)
	    { ret= "ie10";}
	    else
	    { ret= "0"}//IE版本过低
	 }else if (isFF) {
		 ret= "firefox";
    }else if (isOpera) {
    	ret= "opera";
    }else if(isChrome){
    	ret= "chrome";
    }else if(isSafari){
    	ret= "safari";
    }else if(isEdge){
    	ret= "ieedge";
    }else if(isIE11){
    	ret= "ie11";
    }
    
    //alert(ret);
    return ret;
 }
 
 
function isNull(exp){
	if ( typeof(exp)=="undefined" || exp==undefined || exp==null )
	{
		return true;
	}else{
		return false;
	}
}

function isEmpty(exp){
	if(isNull(exp) ||  $.trim(exp)==''){
		return true;
	}else{
		return false;
	}
}


/**
 * 
 */

function getSchoolId(){
	return window.top.$('#school').combobox("getValue");
}

function loadCombotree(selector,value,url,multiple,title){
	if( multiple == null || multiple == undefined){
		multiple=true;
	}
	
	
	$(selector).combotree({
	    url: url,
	    multiple:multiple,
	    prompt:title,
	    queryParams:{
	    	schoolId:getSchoolId()
	    },
	    onlyLeafCheck:multiple?false:true,
	    editable:true,
	    loadFilter:function(data){

        	if(data.status==1){//判断是否成功
        		return data.data;
        	}else{
        		$.messager.alert("提示",data.message,"error");
        		return [];
        	}
        	
        	
        },
        onLoadSuccess:function(){
        	if(value!=null ){
        		if(multiple){
	        		if( isArray(value)){
	        			$(selector).combotree("setValues",value);
	        		}else{
	        			$(selector).combotree("setValues",[value]);
	        		}
        		}else{
        			$(selector).combotree("setValue",value);
        		}
        	}
        }
	})
}

function loadCombobox(selector,value,url,excludeFirst,options){
	
	var opt=$.extend({},{

		url: url,
   	    queryParams:{
   	    	schoolId:getSchoolId()
   	    },
  
   	    panelHeight:220,
        valueField:'id',
        textField:'text',
   	    editable:true,
   	    loadFilter:function(data){

           	if(data.status==1){//判断是否成功
           		if(excludeFirst){
           		   data.data.splice(0,1);
           		}
           		return  data.data;
           	}else{
           		$.messager.alert("提示",data.message,"error");
           		return [];
           	}
           	
           	
         },
         onLoadSuccess:function(){
         	if(value!=null ){
         		$(selector).combobox("setValue",value);
         	}
    
         
         }
		
	},(options||{}));
	
	$(selector).combobox(opt);
	
    
}


function selectRec(datagridSelector,url,reloadGrid,title,data,width,height) {
	var records = $(datagridSelector).datagrid('getChecked');
	console.log(records);
	if(!records.length){
		$.messager.alert("提示","请勾选内容","info");
		return false;
	}
	
	easyui.ext.open ({
 	    width : width&&width>0?width:680,
	    height :height&&height>0?height: 550,
	    title : title&&title!=''?title:'操作',
	    self : false,
	    autoHeight : true,
	    content : 'url:'+url,
	    resizable : false,
	    modal : true,
	    shadow : true,
	    onLoad : function (dlg) {
	    	dlg.reloadGrid=reloadGrid;//
	    	dlg.selectRecs=records;//
	    	dlg.data=data;
  		    var win = dlg.window;
  		    win["init"] (dlg);// 调用远程的js的init方法，参数为当前的dlg对象
	   }
	});

}

function editRec(datagridSelector,url,reloadGrid,title,data,width,height) {
	var records = $(datagridSelector).datagrid('getChecked');
	console.log(records);
	if(!records.length){
		$.messager.alert("提示","请勾选内容","info");
		return false;
	}
	if(records.length>1){
		$.messager.alert("提示","修改只能修改行数据","info");
		return false;
	}
	
	easyui.ext.open ({
 	    width : width&&width>0?width:680,
	    height :height&&height>0?height: 550,
	    title : title&&title!=''?title:'修改记录',
	    self : false,
	    autoHeight : true,
	    content : 'url:'+url,
	    resizable : false,
	    modal : true,
	    shadow : true,
	    onLoad : function (dlg) {
	    	dlg.reloadGrid=reloadGrid;//
	    	dlg.updateRec=records[0];//修改的时候
	    	dlg.data=data;
  		    var win = dlg.window;
  		    win["init"] (dlg);// 调用远程的js的init方法，参数为当前的dlg对象
	   }
	});

}

//跳转到新增用户页面
function addRec(url,reloadGrid,title,data,width,height) {
	easyui.ext.open ({
	    width : 680,
	    height : 550,
	    
	    title : title&&title!=''?title:'新增记录',  
	 	self : false,
	    autoHeight : true,
	    content : 'url:'+url,
	    resizable : false,
	    modal : true,
	    shadow : true,
	    onLoad : function (dlg) {
	    	dlg.reloadGrid=reloadGrid;
	    	dlg.data=data;
  		    var win = dlg.window;
  		    win["init"] (dlg);// 调用远程的js的init方法，参数为当前的dlg对象
	   }
	});
}



function operRec(datagridSelector,url,reloadGrid) {
	var records = $(datagridSelector).datagrid('getChecked');
	if(!records.length){
		$.messager.alert("提示","请勾选内容","info");
		return false;
	}

	$("body").showLoading();

	var parms = {
		selInfos : $.toJSON(records)
	};
	asynPostParam(url, parms, function(data) {
		$("body").hideLoading();

		data = $.evalJSON(data);
		if (data ) {
			if(data.status == 1){
				$.messager.alert("提示", "操作成功", "info", function() {
					if(reloadGrid){
						reloadGrid();
					}
				});
			}else{
				$.messager.alert("提示", data.message, "info");
			}

		}else{
			$.messager.alert("提示", "操作失败，请联系管理员！", "info", function() {
	
			});
		}
	});

}

function initDataGrid(selector,url,queryParams,columns,options){
	
	var opt=$.extend({},{
    	queryParams:queryParams,        		
    	url:url,
		pagination:true,
		striped: true,
		columns:columns,
		border:false,
		nowrap:false,
		remoteSort:false,
		multiSort:false,
		fitColumns: true,
		pagination: true,//表示在datagrid设置分页              
		rownumbers: true,  
		singleSelect: false,
		toolbar:"#top",
		fit: true,
		onBeforeSortColumn :function(	sort,order){
		},
		loadFilter: function(data){
			if(data.data){
				if (data.status==1){
					return data.data;
				} else {
					$.messager.alert('提示',data.message,'error');
					return {};
				}
			}else{
				return data;
			}
		}},(options||{}));
	$(selector).mydatagrid(opt);
}

function getQueryParm(selector,otherParm){
	var parmObject =$(selector).serializeObject();
 	var result=$.extend({},parmObject,otherParm) 
 	return result;
}

// alert(getAge("1980-03-22 10:1:2", "1982-03-22 10:1:2"));
// alert(getAge("1980-06-29", "1984-02-03"));
// alert(getAge("1980-03-22 10:1:2", "1980-03-23 9:1:1"));
// alert(getAge("1981-02-28 10:1:2", "1981-03-01 10:1:2"));
function getDate(date){
	var myDate
	if(date){
		myDate=date;
	}else{
		myDate = new Date();
	}
	
	var year = myDate.getFullYear()+"";
	var month = myDate.getMonth();
	month = month+1;
	month = month+"";
	if(month.length==1){
		month = "0"+month;
	}
	var day = myDate.getDate();
	day = day+"";
	if(day.length==1){
		day = "0"+day;
	}
	return year+"-"+month+"-"+day;
}

function getDate(date){
	var myDate
	if(date){
		myDate=date;
	}else{
		myDate = new Date();
	}
	
	var year = myDate.getFullYear()+"";
	var month = myDate.getMonth();
	month = month+1;
	month = month+"";
	if(month.length==1){
		month = "0"+month;
	}
	var day = myDate.getDate();
	day = day+"";
	if(day.length==1){
		day = "0"+day;
	}
	return year+"-"+month+"-"+day;
}

   function getAge(beginStr, endStr) {
	
	if(beginStr==null || beginStr=='0001-01-01' || endStr==null || endStr=='0001-01-01'){
		return "";
	}
    var reg = new RegExp(
            /^(\d{1,4})(-|\/)(\d{1,2})(-|\/)(\d{1,2})((\s)(\d{1,2})(:)(\d{1,2})(:{0,1})(\d{0,2}))?$/);
    var beginArr = beginStr.match(reg);
    var endArr = endStr.match(reg);

    var days = 0;
    var month = 0;
    var year = 0;

    days = endArr[5] - beginArr[5];
    if (days < 0) {
        month = -1;
        days = 30 + days;
    }

    month = month + (endArr[3] - beginArr[3]);
    if (month < 0) {
        year = -1;
        month = 12 + month;
    }

    year = year + (endArr[1] - beginArr[1]);

    var yearString = year > 0 ? year + "岁" : "";
    var mnthString = month > 0 ? month + "月" : "";
    var dayString = days > 0 ? days + "天" : "";

	
    /*
     * 1 如果岁 大于等于1 那么年龄取 几岁 2 如果 岁等于0 但是月大于1 那么如果天等于0 天小于3天 取小时
     * 例如出生2天 就取 48小时
     */
    var result = "";
    if (year >= 1) {
        result = yearString + mnthString;
    } else {
        if (month >= 1) {
            result = days > 0 ? mnthString + dayString : mnthString;
        } else {
			if(!beginArr[8]){
				beginArr[8]=0;
			}
			if(!beginArr[10]){
				beginArr[10]=0;
			}
			if(!beginArr[12]){
				beginArr[12]=0;
			}

			if(!endArr[8]){
				endArr[8]=0;
			}
			if(!endArr[10]){
				endArr[10]=0;
			}
			if(!endArr[12]){
				endArr[12]=0;
			}
            var begDate = new Date(beginArr[1], beginArr[3] - 1,
                    beginArr[5], beginArr[8], beginArr[10], beginArr[12]);
            var endDate = new Date(endArr[1], endArr[3] - 1, endArr[5],
                    endArr[8], endArr[10], endArr[12]);

            var between = (endDate.getTime() - begDate.getTime()) / 1000;
            days = Math.floor(between / (24 * 3600));
            var hours = Math.floor(between / 3600 - (days * 24));
            var dayString = days > 0 ? days + "天" : "";
            result = days >= 3 ? dayString : days * 24 + hours + "小时";
        }
    }

    return result;
}

   function err(target, message){
       var t = $(target);
       if (t.hasClass('textbox-text')){
           t = t.parent();
       }
       var m = t.next('.error-message');
       if (!m.length){
           m = $('<div class="error-message"></div>').insertAfter(t);
       }
       m.html(message);
   }

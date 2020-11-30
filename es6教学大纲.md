# 数据类型

> https://developer.mozilla.org/zh-CN/docs/Web/JavaScript/Data_structures
>
> https://developer.mozilla.org/zh-CN/docs/Glossary/Primitive

JS语言分为两大类数据类型

- 基本（原始，primitive）数据类型
- 对象数据类型

最新的 ECMAScript 标准定义了 8 种数据类型:

- 7 种原始类型:
  - [Boolean](https://developer.mozilla.org/zh-CN/docs/Glossary/Boolean)
  - [Null](https://developer.mozilla.org/zh-CN/docs/Glossary/Null)
  - [Undefined](https://developer.mozilla.org/zh-CN/docs/Glossary/undefined)
  - [Number](https://developer.mozilla.org/zh-CN/docs/Glossary/Number)
  - [BigInt](https://developer.mozilla.org/zh-CN/docs/Glossary/BigInt)
  - [String](https://developer.mozilla.org/zh-CN/docs/Glossary/字符串)
  - [Symbol](https://developer.mozilla.org/zh-CN/docs/Glossary/Symbol) 
- 和 [Object](https://developer.mozilla.org/zh-CN/docs/Glossary/Object)



## 原始类型

除 Object 以外的所有类型都是不可变的（值本身无法被改变）。例如，与C语言不同，JavaScript 中字符串是不可变的（译注：如，JavaScript 中对字符串的操作一定返回了一个新字符串，原始字符串并没有被改变）。我们称这些类型的值为“原始值”。这些数据是放在栈中的。



### boolean类型

布尔表示一个逻辑实体，可以有两个值：`true` 和 `false`。

**类型转换**

| 序号 | 类型      | 布尔类型值                          |
| ---- | --------- | ----------------------------------- |
| 1    | Null      | 总是为false                         |
| 2    | Undefined | 总是为false                         |
| 3    | Boolean   | 保持原值                            |
| 4    | Number    | +0、-0、NaN、0.0为false，其它为true |
| 5    | String    | 空字符时为false                     |
| 6    | Object    | 都为真                              |

```js
var a = null
//a转换为boolean类型，其值是什么？
```



**默认值**

逻辑运算符||和&&有短路的特性，比如下面的代码

```js
var a = true || f()
var a2 = false || f()
var b = true && f()
var b2 = false && f()
```



这个特性可以给函数参数赋值默认值

```js
function add(m,n){
    m = m || 10
    n = n || 20
    return m + n
}
add()
```

**其它类型转换为boolean类型**

可以用2个`!!`表示一个类型转换为boolean类型之后的值，比如

```js
var f = !!5
var s = "abc"
var f2 = !!s
```



### Null类型

Null 类型只有一个值： `null`,通常来说，表示一个不存在或者无效[object](https://developer.mozilla.org/en-US/docs/Glossary/object)或者地址引用。

```js
var o = null
var o = new Object()
o = null
```



下面是null的常见容易混淆的操作结果示例

```js
typeof null        // "object" (因为一些以前的原因而不是'null')
typeof undefined   // "undefined"
null === undefined // false
null  == undefined // true
null === null // true
null == null // true
!null //true
isNaN(1 + null) // false
isNaN(1 + undefined) // true
```



### Undefined类型

Undefined类型称之为未定义的类型，一个没有被赋值的变量会有个默认值 `undefined`，因为js依据你的值来推断其数据类型，你没有赋值，就无法推断，所以就不知道其类型，也就是说类型就是未定义的.

undefined值主要出现在如下4种情况中

- 从一个对象（包含其原型链上）中获取不到某个属性时
- 一个function没有显式的通过return返回值时
- 定义的变量未赋值时
- 当function实际调用的时候，实际传入到参数小于声明的参数个数时，多余的参数的值为undefined

### 数字类型（Number）

根据 ECMAScript 标准，JavaScript 中只有一种数字类型：基于 IEEE 754 标准的双精度 64 位二进制格式的值（-(253 -1) 到 253 -1）。**它并没有为整数给出一种特定的类型**。除了能够表示浮点数外，还有一些带符号的值：`+Infinity`，`-Infinity` 和 `NaN` (非数值，Not-a-Number)。

### BigInt

[`BigInt`](https://developer.mozilla.org/zh-CN/docs/Web/JavaScript/Reference/Global_Objects/BigInt)类型是 JavaScript 中的一个基础的数值类型，可以用任意精度表示整数。使用 BigInt，您可以安全地存储和操作大整数，甚至可以超过数字的安全整数限制。BigInt是通过在整数末尾附加 `n `或调用构造函数来创建的。

### String

可以用单引号与双引号表示，也可以用`（tab键上面的那个符号）引起来

```js
function f1() {
    return 100
}
var s0 = 'xxx'
var s1 = 'abc' + s0 + 'def'

//这个是引用了一个变量s0
var s2 = `abc${s0} def`
//可以写表达式
var s3 = `abc ${1 + 2} def`
console.log(s3)

//可以调用函数
var s4 = `abc ${f1()} def`
console.log(s4)
//这个就是一个多行的字符串，以前的写法是要加\n
var s100 = `aaa
bbb
ccc
ddd`
console.log(s2)
console.log(s100)
```

### Symbol

符号(Symbols)是ECMAScript 第6版新定义的。符号类型是唯一的并且是不可修改的, 并且也可以用来作为Object的key的值(如下). 在某些语言当中也有类似的原子类型(Atoms). 你也可以认为为它们是C里面的枚举类型. 更多细节请看 [Symbol](https://developer.mozilla.org/zh-CN/docs/Glossary/Symbol) 和 [`Symbol`](https://developer.mozilla.org/zh-CN/docs/Web/JavaScript/Reference/Global_Objects/Symbol) 。

```js
var o = {}
o.a = '100'
o.a = true

console.log(o.a)
//像上面的情况就会产生覆盖的问题，因为属性名是一样的

function f1(gender) {
    if (gender == 'male') {
    } else if (gender == 'female') {
    }
}

f1('males')
//可以改成下面的这样，直接点出来，不会出错，即使错了也会在开发阶段发现
// f1(p.males)

//推出一个Symbol类型，它是唯一的

var s1 = Symbol('miaoshu')
var s2 = Symbol('miaoshu')

console.log(s1)
console.log(s1 === s2)

o[s1] = 'abc'
o[s2] = 'def'
console.log(o[s1])
console.log(o[s2])
```



```js
//假设我们不能或不知道s1这个变量，我们如何获取对象o的s1属性的值呢？
//如果我们丢失了变量s1，s2的访问，那么o对象的这2个属性就永远访问不到了。

var s3 = Symbol.for('全局注册的一个符号')
o[s3] = 200
console.log(o[s3])
//假定s3变量我们无法访问，那么可以这样
var s4 = Symbol.for('全局注册的一个符号')
console.log(o[s4])
//Symbol.for的原理是这样：第一次依据描述是全局注册一个
//第二次以及后来的调用，依据描述在全局注册表里面查找，找到就返回

//keyFor方法返回的是符号的描述
var result = Symbol.keyFor(s3)
console.log(result)

var gender = {
    male: Symbol.for('male'),
    female: Symbol.for('female'),
}

function f2(g) {
    if (g == gender.male) {
        console.log('这是男生')
    }
}

f2(gender.male)
```





### 包装类型

除了 `null` 和 `undefined`之外，所有基本类型都有其对应的包装对象：

- [`String`](https://developer.mozilla.org/zh-CN/docs/Web/JavaScript/Reference/String) 为字符串基本类型。
- [`Number`](https://developer.mozilla.org/zh-CN/docs/Web/JavaScript/Reference/Global_Objects/Number) 为数值基本类型。
- [`BigInt`](https://developer.mozilla.org/zh-CN/docs/Web/JavaScript/Reference/Global_Objects/BigInt) 为大整数基本类型。
- [`Boolean`](https://developer.mozilla.org/zh-CN/docs/Web/JavaScript/Reference/Boolean) 为布尔基本类型。
- [`Symbol`](https://developer.mozilla.org/zh-CN/docs/Web/JavaScript/Reference/Global_Objects/Symbol) 为字面量基本类型。

这个包裹对象的[`valueOf()`](https://developer.mozilla.org/zh-CN/docs/Web/JavaScript/Reference/Global_Objects/Object/valueOf)方法返回基本类型值。

> Symbol类型是不能使用new Symbol创建一个包装类型的，会抛出TypeError错误，围绕原始数据类型创建一个显式包装器对象从 ECMAScript 6 开始不再被支持。 然而，现有的原始包装器对象，如 `new Boolean`、`new String`以及`new Number`，因为遗留原因仍可被创建

## 对象类型（Object）

在计算机科学中, 对象是指内存中的可以被 [标识符](https://developer.mozilla.org/zh-CN/docs/Glossary/Identifier)引用的一块区域.在 Javascript 里，对象可以被看作是一组属性的集合。这些属性还可以被增减。属性的值可以是任意类型，包括具有复杂数据结构的对象。属性使用键来标识，它的键值可以是一个字符串或者符号值（Symbol）。

一个 Javascript 对象就是键和值之间的映射.。键是一个字符串（或者 [`Symbol`](https://developer.mozilla.org/zh-CN/docs/Web/JavaScript/Reference/Global_Objects/Symbol)） ，值可以是任意类型的值。 这使得对象非常符合 [哈希表](http://en.wikipedia.org/wiki/Hash_table)。

> 函数是一个附带可被调用功能的常规对象。



## typeof

> https://developer.mozilla.org/zh-CN/docs/Web/JavaScript/Reference/Operators/typeof

下表总结了 `typeof` 可能的返回值。有关类型和原始值的更多信息，可查看 [JavaScript 数据结构](https://developer.mozilla.org/zh-CN/docs/Web/JavaScript/Data_structures) 页面。

| 类型                                                         | 结果                                                         |
| :----------------------------------------------------------- | :----------------------------------------------------------- |
| [Undefined](https://developer.mozilla.org/zh-CN/docs/Glossary/undefined) | `"undefined"`                                                |
| [Null](https://developer.mozilla.org/zh-CN/docs/Glossary/Null) | `"object"` (见[下文](https://developer.mozilla.org/zh-CN/docs/Web/JavaScript/Reference/Operators/typeof#null)) |
| [Boolean](https://developer.mozilla.org/zh-CN/docs/Glossary/Boolean) | `"boolean"`                                                  |
| [Number](https://developer.mozilla.org/zh-CN/docs/Glossary/Number) | `"number"`                                                   |
| [BigInt](https://developer.mozilla.org/zh-CN/docs/Glossary/BigInt)(ECMAScript 2020 新增) | `"bigint"`                                                   |
| [String](https://developer.mozilla.org/zh-CN/docs/Glossary/字符串) | `"string"`                                                   |
| [Symbol](https://developer.mozilla.org/zh-CN/docs/Glossary/Symbol) (ECMAScript 2015 新增) | `"symbol"`                                                   |
| 宿主对象（由 JS 环境提供）                                   | *取决于具体实现*                                             |
| [Function](https://developer.mozilla.org/zh-CN/docs/Glossary/Function) 对象 (按照 ECMA-262 规范实现 [[Call]]) | `"function"`                                                 |
| 其他任何对象                                                 | `"object"`                                                   |

```js
console.log(typeof 42);
// expected output: "number"

console.log(typeof 'blubber');
// expected output: "string"

console.log(typeof true);
// expected output: "boolean"

console.log(typeof undeclaredVariable);
// expected output: "undefined"
```



```js
// 数值
typeof 37 === 'number';
typeof 3.14 === 'number';
typeof(42) === 'number';
typeof Math.LN2 === 'number';
typeof Infinity === 'number';
typeof NaN === 'number'; // 尽管它是 "Not-A-Number" (非数值) 的缩写
typeof Number(1) === 'number'; // Number 会尝试把参数解析成数值

typeof 42n === 'bigint';


// 字符串
typeof '' === 'string';
typeof 'bla' === 'string';
typeof `template literal` === 'string';
typeof '1' === 'string'; // 注意内容为数字的字符串仍是字符串
typeof (typeof 1) === 'string'; // typeof 总是返回一个字符串
typeof String(1) === 'string'; // String 将任意值转换为字符串，比 toString 更安全


// 布尔值
typeof true === 'boolean';
typeof false === 'boolean';
typeof Boolean(1) === 'boolean'; // Boolean() 会基于参数是真值还是虚值进行转换
typeof !!(1) === 'boolean'; // 两次调用 ! (逻辑非) 操作符相当于 Boolean()


// Symbols
typeof Symbol() === 'symbol';
typeof Symbol('foo') === 'symbol';
typeof Symbol.iterator === 'symbol';


// Undefined
typeof undefined === 'undefined';
typeof declaredButUndefinedVariable === 'undefined';
typeof undeclaredVariable === 'undefined'; 


// 对象
typeof {a: 1} === 'object';

// 使用 Array.isArray 或者 Object.prototype.toString.call
// 区分数组和普通对象
typeof [1, 2, 4] === 'object';

typeof new Date() === 'object';
typeof /regex/ === 'object'; // 历史结果请参阅正则表达式部分


// 下面的例子令人迷惑，非常危险，没有用处。避免使用它们。
typeof new Boolean(true) === 'object';
typeof new Number(1) === 'object';
typeof new String('abc') === 'object';

// 函数
typeof function() {} === 'function';
typeof class C {} === 'function'
typeof Math.sin === 'function';
```

注意括号的使用

```js
// 括号有无将决定表达式的类型。
var iData = 99;

typeof iData + ' Wisen'; // 'number Wisen'
typeof (iData + ' Wisen'); // 'string'
```



# ES简介 

ES的全称是EcmaScript ，它是欧洲计算机协会制定的脚本语言的一个标准，Javascript只是这个标准的一个实现，EcmaScript存在多个版本，EcmaScript 2015（ES2015，ES6）是变化特别大的一个版本，增加了许多的特性，并且向后兼容

在2016年6月推出第7版，2017年6月推出第8版，2018年6月推出第9版，2019年6月推出第10版。这几个版本分别简称为es2016,es2017，es2018，es2019.

**平时称呼的es6指代5.1版以后的所有版本，5.1版本是2009年12月推出。**

## DOM扩展

- querySelector

- querySelectorAll

- getElementsByClassName

- classlist

- dataset

- scrollIntoView

- 焦点管理

- 文档加载

```html
<input type="button" value="scrollIntoView" id="btnScroll" />
<p id="a" class="box bold myclass">pppp</p>
<p id="b" class="box" aaa="100" data-age="18" data-name="hlm">qqq22</p>

<div style="height: 300px"></div>
<span id="abc">这是span</span>
```





```js
//querySelector支持很多种选择器，类似于jQUery的功能
//只选择符合条件的第一个
var result = document.querySelector('p')
// console.log(result)
// console.log(result.length)

//选择所有符合条件的元素，是一个数组
var result2 = document.querySelectorAll('p')
// console.log(result2)
//console.log(result2.length)

//得到所有class为box的元素
var result3 = document.getElementsByClassName('box')
//console.log(result3)

var result4 = document.getElementById('a')
result4.classList.forEach(function (value, key, ele) {
    console.log(value)
})

result4.classList.remove('myclass')

result4.classList.add('myclass2')
result4.classList.add('myclass3')
result4.classList.add('box')

var result5 = document.getElementById('b')

var x = result5.dataset.age
var y = result5.dataset.name
console.log(x)
console.log(y)

var btn = document.getElementById('btnScroll')
btn.addEventListener('click', function () {
    alert('xx')
    var abcSpan = document.getElementById('abc')
    abcSpan.scrollIntoView()
})


//文档的加载状态改变事件
addEventListener(
    'readystatechange',
    function (e) {
        //document.readyState的值有：
        //uninitialized（未初始化）-》 loading-》interactive（交互）-》complete
        console.log(document.readyState)
        console.log(e)
    },
    true
)

addEventListener('DOMContentLoaded', function (e) {
    console.log('文档树加载完成')
})

addEventListener('load', function () {
    console.log('整个页面所有的内容都加载完毕')
})
```



## BOM扩展

### hash

hash就是网址上`#`后面一部分的数据，比如http://localhost:8080/first?id=100#abc,这个网址的hash值就是abc

hash通常用来在页面中进行定位，就是通常所说的锚点（anchor），它的特点是：

- 改变hash值不会发起请求，仅仅只是在浏览器端进行
- 改变hash值会改变浏览器的浏览历史

在es6之后给hash数据处理添加了一个hashchange事件，就是当hash值改变的时候会引发此事件。



```js
window.addEventListener('hashchange', function (e) {
    e.preventDefault()
    //console.log(e)

    //获取新的url地址
    var newUrl = e.newURL
    //写点代码，把hash值取到

    //获取hash值
    var index = newUrl.indexOf('#')
    var hashValue = newUrl.substring(index + 1)

    console.log(hashValue)
    //利用获取到的hash值，构建一个请求地址
    var reqUrl = 'localhost:8080/firstweb/' + hashvalue

    //利用这个请求地址，发起ajax请求，利用请求的结果数据填充到当前页面
    //这就是hash技术+ ajax处理单页路由，也就是所谓的hjax技术
    //vue框架实现了类似的技术
    $.get(requet, function (result) {})
```



> 在caniuse.com网址可以知道哪些浏览器版本支持hashchange事件

### history

页面的历史状态发生变化时将触发popstate事件，使用pushState与replaceState方法并不会触发该事件，只有点击浏览器的前进后退按钮或使用back(),forward(),go()方法时才会触发

另外，该事件只针对同一个文档，如果浏览历史的切换，导致加载不同的文档，该事件也不会触发

```html
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Document</title>

    <style>
      div {
        height: 300px;
        width: 300px;
        border: 1px solid rebeccapurple;
      }
    </style>
  </head>
  <body>
    <!-- 利用hash值改变，页面不卸载，但浏览器历史记录改变的特性 -->
    <a href="#abc">调到锚点abc处</a>
    <a href="#def">调到锚点def处</a>

    <div class=""></div>
    <div></div>
    <div></div>
    <div id="abc">abcccccxcx</div>

    <div></div>
    <div></div>

    <p id="def">asd;lfkjasl;dfkj;alskjdf;laskdfjasdfasd</p>
    <script>
      /* es6对history的扩展主要是添加了这个popstate事件以及pushState，replaceState这2个方法
      
      利用这个特点与hjax类似，有一种技术叫pjax来做单页路由

      所以做单页路由有2种方法，hash方法，history方法
       */
      addEventListener('popstate', function (e) {
        console.log('pop state 事件发生了---')
        console.log(e)
      })
    </script>
  </body>
</html>

```



# 变量声明与作用域

在js中，有三种声明变量的关键字：

- var
- let
- const

## var

var声明变量有如下几个特点：

- 可以重复声明

```js
 var a = 100
 var a = "abc" //下面的覆盖掉上面的东西
```

- 依据声明的情况会成为全局对象的成员

```js
//比如你在脚本块中声明变量就变成了window对象的成员
var a = 100;
window.a //输出100
```

下面的代码在执行后，有哪几个会成为window的成员

```js
var a = 100
var a = 'abc'

function f() {
    var b = 200
    c = 300
}
f()
```

结果是a，f，c都会成为window的成员，b不会成为，因为js中有函数作用域，b是在函数中声明的，所以外面不会访问得到。

c声明的时候没有指定var，所以在js中就会把其变为一个全局变量

- 会有变量提升（Hoisting）的问题

  输入下面的代码

  ```js
  console.log(a)//报错，因为未声明变量
  ```

  输入下面的代码

  ```js
  
  console.log(a) //输出undefined
  var a 
  ```

  上面的写法就是所谓的变量提升，可以这样理解：在整个js文件运行前，会执行全局扫描，然后会把所有用var声明的东西，提升到顶部,让js执行引擎知道有这么一个东西

  输入下面的代码：

  ```js
  console.log(a) //undefined
  var a = 200
  console.log(a)  //200
  ```

  除了变量会提升外，函数声明也会有提升的情况,并且函数和变量相比会被优先提升，这意味着函数会被提升到更靠前的位置

## 作用域

下面的代码输出的结果都是200，因为早期js中作用域只有全局作用域与函数作用域，没有块级作用域的概念。所谓的块指的是一段大括号括起来的代码段

```js
var a = 100
var flag = true
if (flag) {
    var a = 200
    console.log(a)
}
console.log(a)
```

如果上面的代码改成下面这样,分别输出200,100

```js
var a = 100

var flag = true

function f() {
    var a = 200
    console.log(a) // 200
}

f()
console.log(a) //100
```



## let

由于var变量的不良特性导致的一些奇怪问题，所以js退出一个新的作用域：块级作用域。块级作用域主要是用let与const关键字来声明

> 总原则：以后忘掉var这个关键字

let的特点如下：

- 块级作用域
- 不会进行提升（hoisting）
- 不会成为顶级对象的成员
- 不允许重复声明

> https://developer.mozilla.org/zh-CN/docs/Web/JavaScript/Reference/Statements/let

### 块级作用域

下面的代码由于用let声明，它是块级作用域的，所以输出2，1

```js
let x = 1

if (x === 1) {
    let x = 2
    console.log(x) //2
}
console.log(x) //1
```

对照着下面的代码

```js
var x = 1

if (x === 1) {
    var x = 2
    console.log(x) //2
}
console.log(x) //2
```

### 不会进行提升

下面的代码会报错，因为let声明的变量不会提升，所以记住：let先声明才能用

```js
console.log(a)
let a = 200
```

> console.log执行时，js解析知道有a这个变量，但是js解析器把其放在暂时性死区（TDA）里面。总之就是我知道，但你不能用

### 不会成为顶级对象的成员

下面的代码输出的是undefined，因为它不会成为window的属性

```js
let a = 200
console.log(window.a)//undefined
```

### 不能重复声明

下面的代码会报错，说已经声明过了变量

```js
let a = 200
let a = 300
```

let是块级作用域的，如果它声明的变量是在全局位置，那么它就是全局可以用的，比如下面的代码中，函数f是可以使用变量a的

```js
let a = 10
function f() {
    console.log(a)
}
f()
```

## const

const与let一样，但主要的区别是其用来声明常量，let用来声明变量。用const声明之后，不能改变其内容，比如：

```js
let a = 200
a = 300
console.log(a) //这里没有问题，let声明变量

const b = 2000
b = 3000 //这里报错
console.log(b)
```

const声明的东西，要区分是基本类型还是引用类型，上面的案例表明的是基本类型的特性。

下面的代码，const修饰的o引用的是一个对象，也就是说是一个引用类型，此时表明o不能指向别的引用，但o本身指向的对象是可以修改的。

```js
const o = { name: 'def' }
o.name = 'xxx'
console.log(o.name) //改变对象值可以

o = { age: 18 } // 改变o的指向不行，会报错
console.log(o.name)
console.log(o.age)
```

## eval作用域

eval函数是可以执行js代码的，比如下面的代码最终会输出50

```js
eval('var a = 20;var b = 30;var c = a + b;console.log(c)')
```

如果在eval中用val声明变量，那么在eval外面也是可以使用的

```js
eval('var a = 100')
console.log(a) //非严格模式，正常输出100
```

但是如果启用严格模式，那么eval中声明的变量就不能使用，相当于开启了eval作用域

```js
"use strict"
eval('var a = 100')
console.log(a) //报错，访问不到a
```

## 作用域链

```js
let a = 100
function f1(){
    var b = 200
    a = 1000
    //函数f1内找不到，就找全局
    console.log(a)  // 1000
    function f2(){
        //函数f2内找不到，就找父级
        console.log(b)   // 200
        //函数f2内找不到，就找父级，
        //父级f1找不到，就找父级的父级---全局，
        //这就是作用域链
        console.log(a) // 1000
    }
    f2()
}
f1()
```



## 总结

1. 以后声明变量只用let或const
2. let与const都是块级作用域的
3. const表明是一个常量
   1. 赋值为基本类型时，值就不能改变了
   2. 赋值为引用类型时，不能改变引用，但能改变被引用对象的内容
4. let与const有以下特性
   1. 不能重复声明
   2. 块级作用域
   3. 不会成为顶级对象的成员
   4. 不会进行提升
5. js作用域总共有4种
   1. 全局作用域
   2. 函数作用域
   3. 代码块作用域
   4. eval作用域



# 数组与集合

数组域集合都是用来存放很多数据的，在目前js中，主要有

- 数组
- Set
- Map

## 数组

> https://developer.mozilla.org/zh-CN/docs/Web/JavaScript/Reference/Global_Objects/Array

### 数组的创建

```js
var arr = ["a","b","c","d"]
//创建一个长度为7的数组
var arr2 = new Array(7)
```



### 常用的方法

- forEach
- push
- pop
- unshift
- shift
- includes
- slice
- splice
- find
- findIndex
- some

```js
let arr = ['a', 'b', 'c', 'd']
//创建一个长度为7的数组
let arr2 = new Array(7)

// push是往数组中添加数据
arr.push('e')
//pop是从里面取出数据，从尾部开始取
let result = arr.pop()
console.log(result)

arr.forEach(function (value, index, a) {
    console.log(value, index)
})
```

**foreach**

```js
//下面代码中的return true只是从回调函数中返回，forEach并没有结束
// 所以log（xxxx)会一直输出
//forEach方法不适合找东西，找到return不停止循环
arr.forEach(function (value, index, a) {
    if (value === 'b') {
        console.log(value, index)
        return true
    } else {
        console.log('xxxx')
    }
})
```

shift与unshifit

```js
//shift就是从数组的首部（索引0）弹出一个元素
//  let result2 = arr.shift()
//console.log(result2)
//console.log(arr.length)
//是在数组的索引0处开始插入参数中的所有数据
arr.unshift(1, 2, 3) // 1,2,3,a,b,c,d
console.log(arr)
```

include

```js
//是判断数组中有没有这个数
let result3 = arr.includes('cc')
```

slice

```js
//是从数组中切取一部分数据返回一个结果数组，切得行为是[)
let result4 = arr.slice(0, 2)
console.log(result4)
//不影响原来数组中的数据
console.log(arr)
```

splice

```js
//arr = [a,b,c,d]
let result5 = arr.splice(1, 1)
console.log(result5) // b
console.log(arr)  //a,c,d

let result6 = arr.splice(1, 2)
console.log(result6) //[b,c]
console.log(arr) // [a,d]

let result6 = arr.splice(1, 1, 100)
console.log(result6)
console.log(arr) // a 100 c d

let result6 = arr.splice(1, 1, 100, 200)
console.log(result6)
console.log(arr) //a 100,200,c,d
```

findIndex

```js
//只要回调函数返回true就表示找到 立即结束循环，找不到就返回-1
let index = arr.findIndex(function (v) {
    if (v === 'c') {
        return true
    }
})
console.log(index)
```

some

```js
//只要回调函数返回true，就表示找到，立即结束循环，否则返回false
let index2 = arr.some(function (v) {
    if (v === 'cc') {
        return 'c'
    }
})
console.log(index2)
```

find

```js
//回调返回返回true，表示找到了元素，如果找不到就返回undefined
let ele = arr.find(function (v) {
    if (v === 'c') {
        return true
    }
})
console.log(ele) // c
```

filter

```js
//遍历数组，所有回调函数返回true的数据都会放置到返回的数组中
let newArr = arr.filter(function (v) {
    return v === 'c' || v === 'd'
})
console.log(newArr) //c,d
```



### 数组的解构（Destruction）

**解构赋值**语法是一种 Javascript 表达式。通过**解构赋值,** 可以将属性/值从对象/数组中取出,赋值给其他变量。

> https://developer.mozilla.org/zh-CN/docs/Web/JavaScript/Reference/Operators/Destructuring_assignment

- 普通的解构

```js
let arr = ['a', 'b', 'c', 'd']
//原始的取出数组的值，并赋值给变量
let a1 = arr[0]
let a2 = arr[1]
let a3 = arr[2]
let a4 = arr[3]
//这种就称之为解构赋值，一次性赋值给4个变量
let [a, b, c, d] = arr
console.log(a, b, c, d)
```

- 只解构部分

```js
let [x, y] = arr
console.log(x, y)
//或者这样写
let x,y
[x,y]= arr
console.log(x, y)
```

- 函数返回值解构

```js
function f() {
    return [100, 200]
}
let [m, n] = f()
console.log(m, n)
```

- 交换变量

```js
let a = 1
let b = 3

;[a, b] = [b, a]
console.log(a) // 3
console.log(b) // 1
```

- 逗号跳过（忽略某些值）

```js
let [a1, , , a4] = arr
console.log(a1, a4) //a,d

let [, b2, , b4] = arr
console.log(b2, b4) //b,d
```

- 默认值

```js
let arr2 = [100]
let [a1, a2] = arr2
console.log(a1, a2) //100,undefined
let [b1 = 1, b2 = 2] = arr2
console.log(b1, b2) //100,2
```

- 嵌套数组解构

```js
let arr3 = [1, 2, [100, 200]]
// let [a, b, c, d] = arr3
// console.log(a) // 1
// console.log(b) // 2
// console.log(c) // [100,200]
// console.log(d) // undefined

let [a, b, [c, d]] = arr3
console.log(a, b, c, d)
```



## 循环遍历

### for

```js
let arr = ['a', 'b', 'c', 'd']

for (let i = 0; i < arr.length; i++) {
    //console.log(arr[i])
}
```

### for in

```js
//for in 反射型循环
for (let index in arr) {
    //index是数组的下标，arr[index]就是数组的值
    // console.log(index, arr[index])
}
```



### for of

```js
//for of
for (let item of arr) {
    //输出的是数组的每个元素
    console.log(item)
}
```

一个对象能否用for of循环，取决于其是否是一个`Iterable`对象，也就是有迭代器（`Iterator`)，可迭代对象的迭代器是一个函数，其名字是固定的，是Symbol.iterator.

> ```js
> var arr = [11,22,33]
> arr[Symbol.iterator]; //ƒ values() { [native code] }
> var o = {name:"aa"}
> o[Symbol.iterator] //undefined
> ```
>
> arr的迭代器不为空，所以其可以用在for of循环里，对象o的迭代器为undefined，所以不能用在for of循环里

## Set

**`Set`** 对象允许你存储任何类型的唯一值，无论是[原始值](https://developer.mozilla.org/zh-CN/docs/Glossary/Primitive)或者是对象引用。也就是Set中的数据是不重复的。

```js
//创建set集合
let data = new Set()

data.add(100)
data.add(200)
data.add(100)
for (let item of data) {
    //输出100,200，重复项不会添加到set集合中
    console.log(item)
}

let exist = data.has(200)
console.log(exist) //true

let exist2 = data.has(300)
console.log(exist2) //false

//删除数据
data.delete(100)
let exist3 = data.has(100)
console.log(exist3) //false

//set集合的键就是其值
for (let k of data.keys()) {
    console.log(k)
}

for (let v of data.values()) {
    console.log(v)
}

for (let entry of data.entries()) {
    //索引0取得键的值，1是值得数据
    console.log(entry[0], entry[1])
}
```



### WeakSet

**`WeakSet`** 对象允许你将*弱保持对象*存储在一个集合中。`WeakSet` 对象是一些对象值的集合, 并且其中的每个对象值都只能出现一次。在`WeakSet`的集合中是唯一的

它和 [`Set`](https://developer.mozilla.org/zh-CN/docs/Web/JavaScript/Reference/Global_Objects/Set) 对象的区别有两点:

- 与`Set`相比，`WeakSet` 只能是**对象的集合**，而不能是任何类型的任意值。
- `WeakSet`持弱引用：集合中对象的引用为弱引用。 如果没有其他的对`WeakSet`中对象的引用，那么这些对象会被当成垃圾回收掉。 这也意味着WeakSet中没有存储当前对象的列表。 正因为这样，`WeakSet` 是不可枚举的。

```js
var ws = new WeakSet();
var foo = {};
var bar = {};

ws.add(foo);
ws.add(bar);

ws.has(foo);    // true
ws.has(bar);   // true

ws.delete(foo); // 从set中删除 foo 对象
ws.has(foo);    // false, foo 对象已经被删除了
ws.has(bar);    // true, bar 依然存在
```





## Map

**`Map`** 对象保存键值对，并且能够记住键的原始插入顺序。任何值(对象或者[原始值](https://developer.mozilla.org/zh-CN/docs/Glossary/Primitive)) 都可以作为一个键或一个值。

```js
//创建Map集合
let data = new Map()
//键和值都可以是任何类型的数据
data.set(100, 'abc')
data.set(200, 'def')

console.log(data.size)
let result = data.get(100)
console.log(result)

//依据键来查找map中是否有此值
let have = data.has(200)
console.log(have)

for (let item of data) {
    //每一个条目是一个数组，固定索引0是键值，索引1是value值
    console.log(item[0], item[1])
}

//可以把一个二维的2个元素的数组转换为一个map

let arr = [
    [300, 'xxx'],
    [400, 'yyy'],
    [500, 'zzz'],
]

let data2 = new Map(arr)
console.log(data2.get(400))
console.log(data2.size) //3

for (let k of data.keys()) {
    console.log(k)
}

for (let v of data.values()) {
    console.log(v)
}

for (let entry of data.entries()) {
    console.log(entry[0], entry[1])
}
```



### weakmap

**`WeakMap`** 对象是一组键/值对的集合，其中的键是弱引用的。其键必须是对象，而值可以是任意的。

```js
const wm1 = new WeakMap(),
      wm2 = new WeakMap(),
      wm3 = new WeakMap();
const o1 = {},
      o2 = function(){},
      o3 = window;

wm1.set(o1, 37);
wm1.set(o2, "azerty");
wm2.set(o1, o2); // value可以是任意值,包括一个对象或一个函数
wm2.set(o3, undefined);
wm2.set(wm1, wm2); // 键和值可以是任意对象,甚至另外一个WeakMap对象

wm1.get(o2); // "azerty"
wm2.get(o2); // undefined,wm2中没有o2这个键
wm2.get(o3); // undefined,值就是undefined

wm1.has(o2); // true
wm2.has(o2); // false
wm2.has(o3); // true (即使值是undefined)

wm3.set(o1, 37);
wm3.get(o1); // 37

wm1.has(o1);   // true
wm1.delete(o1);
wm1.has(o1);   // false
```



## Spread

> https://developer.mozilla.org/zh-CN/docs/Web/JavaScript/Reference/Operators/Spread_syntax

> **Spread syntax** (`...`) allows an iterable such as an array expression or string to be expanded in places where zero or more arguments (for function calls) or elements (for array literals) are expected, or an object expression to be expanded in places where zero or more key-value pairs (for object literals) are expected.

### 数组的展开

```js
let arr = ['a', 'b', 'c', 'd']
//展开运算符就是三个点

//这里的展开运算符相当于复制了一个数组
let arr2 = [...arr]
let arr3 = [...arr, 'e', 'f']

function add(m, n) {
    return m + n
}

// let result = add(100,200)
let result = add(...[100, 200])
console.log(result)
```



### Map的展开

可以利用展开运算符将一个Map对象转换成一个二维键值对数组

```js
let map = new Map()
map.set(100, 'abc')
map.set(200, 'def')
map.set(300, 'xxx')
//[[100,abc],[200,def],[300,xxx]]
console.log([...map])
```

## 总结

1. 数组
   1. 创建
   2. 常用方法
2. 循环遍历
3. Set
4. Map
5. 解构（Destruction）
   1. 数组的解构[]
6. 展开（Spread）
   1. 三个点
   2. 数组的展开
   4. Map的展开



# 函数

函数是一个功能块，是给一大段代码取了个名字，函数的好处是便于修改维护。可以避免过多的复制粘贴。

## 函数创建

函数的创建有3种方法

- 函数声明
- 函数表达式
- 利用Function这个自带的对象来创建函数

```js
//函数声明的
/*  function add(m,n){
      return m + n

    }

    add(100,200) */

//函数表单式
//可以理解为let a = 100,理解为一个赋值的表达式
/*  let add = function (m, n) {
        return m + n
      }

      add(100, 200) */

//第三种：不推荐使用，了解即可
let add = new Function('m', 'n', 'return m + n')
let result = add(100, 200)
console.log(result)
```

## 函数的数据特性

指的是把函数当成一个数据来使用，比如当成100，“abc”这样的数据来用，主要是函数作为其它函数的参数值和把函数作为其它函数的返回值。

### 函数作为参数

```js
function gaojie(m) {
    m()
    //console.log(m)
}
function dijie() {
    console.log('dijie')
}
// gaojie(5)
gaojie(dijie)

```

函数作为参数常见于回调函数与时间处理函数

```js
$(function(){}) //纯回调函数
btn.addEventListner("click",function(){})//事件处理
```

请思考下面的写法

```js
function gaojie(m) {
    console.log(m)
}

function dijie() {
    // console.log('dijie')
    return 100
}
// gaojie(5)
gaojie(dijie) // 把dijie这个函数作为参数传递
gaojie(dijie()) //====gaojie(100)
```



### 函数作为返回值

```js
function p2() {
    //返回了一个匿名函数
    return function () {
        return 100
    }
}
//fun这个变量指代的就是返回的匿名函数，相当于此时函数名是fun了
let fun = p2()
//既然是个函数，所以可以继续调用
let result3 = fun()
//上面两行的写法等价于下面一行的写法
let result2 = p2()()
console.log(result2)

//let result3 = p2()(5,6) ===>result3 = 5+6 = 11
  
```



### IIFE

IIFE:immediately Invoke Function expression  :立即执行的函数表达式

此种函数有一种重要的作用就是减少全局变量

```js
(function () {
        console.log('IIFE')
      })()
//第二种写法
(function(){console.log("xxx")}())
```

IIFE函数也是可以传递参数的

```js
;(function (m, n) {
    let result = m + n
    console.log(result)
})(5, 6)
```

IIFE既然可以传递参数，因为函数也可以当成数据来使用，所以IIFe表达式也是可以传递函数作为参数的

```js
;(function (f) {
    f()
})(function () {
    console.log('xxx')
})
```

IIFE传递参数时，有时为了能快速了解匿名函数大致的结构以及传递的参数是，就需要能很快，很容易找到传递的参数，但下面的写法可能就很困难

```js

      (function(f){
//想象有1000行代码
          
          
          
      })(100)
```

可以改成下面的写法

```js
(function(value,fun){
    //value = 100,fun = 匿名函数
    fun(value) //这里就可以快速的看到IIFE函数运用参数的情况
})(100,function(value2){ //匿名函数
    //IIFE具体的执行逻辑代码都在这里。。。

    console.log(value2)
})
```

上面的代码执行之后，会立即在控制台输出100





## 参数

### arguments

**`arguments`** 是一个对应于传递给函数的参数的类数组对象。它主要用来获取函数被调用时实际传递的参数个数

```js
function f(){
    console.log(typeof arguments);    // 'object'
    console.log(arguments.length); //3,实际传递的参数个数，数组也有length属性
}
f(100,200,300)
```



`arguments`对象是所有（非箭头）函数中都可用的**局部变量**。你可以使用`arguments`对象在函数中引用函数的参数。此对象包含传递给函数的每个参数，第一个参数在索引0处。例如，如果一个函数传递了三个参数，你可以以如下方式引用他们：

```js
arguments[0]
arguments[1]
arguments[2]
```



### 参数默认值

```js
function f(m, n) {
    n = n || -1
}

//1.总原则：如果要设定函数参数的默认值，这些参数都应该放在函数的最后
// 参数的值，如果调用的时候有传值，就以传递的值为准，没有传值才用默认值
function add(m, x = 1, y = 2) {
    return m + x + y
}
console.log(add()) //undefined+ 3 ===NaN
console.log(add(100)) //103
console.log(add(100, 200)) //302
console.log(add(100, 200, 300)) //600
console.log(add(100, 200, 300, 400)) //600 ,400被忽略

function add2(x = 1, y = x) {
    return x + y
}
//2.参数的默认值得处理是在函数被调用的时候（运行）处理的
console.log(add2(100)) //200

function add3(
x,
 y = (function () {
    console.log('xxx')
    return 1000
})()
) {
    return x + y
}

console.log(add3(100))
```

### 解构函数参数

回忆一下解构运算

```js
//标准的解构运算
let [a, b] = [100, 200]
console.log(a, b)
```

函数参数的解构写法如下

```js
function add([m, n]) {
    return m + n
}

let arr = [100, 200]
let result = add(arr)
console.log('result: ', result)

function add2(arr) {
    return arr[0] + arr[1]
}
```



### Rest（剩余参数）

```js
//rest:剩下的
function add(m, ...aaaa) {
    // m = 100,aaaa是个数组，包含4个实际参数中除了100之外剩下的参数,也就是200,300,400
    let result = m
    for (let item of aaaa) {
        result += item
    }
    return result
}

// console.log(add(100, 200, 300, 400))

//2. 表明函数中可以只有剩余参数
function add2(...aaaa) {
    // m = 100,aaaa是个数组，包含4个实际参数中除了100之外剩下的参数
    let result = 0
    for (let item of aaaa) {
        result += item
    }
    return result
}

//console.log(add2(100, 200, 300, 400))

```

剩余参数和 `arguments`对象之间的区别主要有三个：

- 剩余参数只包含那些没有对应形参的实参，而 `arguments` 对象包含了传给函数的所有实参。
- `arguments`对象不是一个真正的数组，而剩余参数是真正的 `Array`实例，也就是说你能够在它上面直接使用所有的数组方法，比如 `sort`，`map`，`forEach`或`pop`。
- `arguments`对象还有一些附加的属性 （如`callee`属性）。



#### 解构剩余参数

剩余参数可以被解构，这意味着他们的数据可以被解包到不同的变量中

```js
function f(...[a, b, c]) {
  return a + b + c;
}

f(1)          // NaN (b and c are undefined)
f(1, 2, 3)    // 6
f(1, 2, 3, 4) // 6 (the fourth parameter is not destructured)
```



> 剩余语法(Rest syntax) 看起来和展开语法完全相同，不同点在于, 剩余参数用于解构数组和对象。从某种意义上说，剩余语法与展开语法是相反的：展开语法将数组展开为其中的各个元素，而剩余语法则是将多个元素收集起来并“凝聚”为单个元素



## 箭头函数

**箭头函数表达式**的语法比[函数表达式](https://developer.mozilla.org/zh-CN/docs/Web/JavaScript/Reference/Operators/function)更简洁，并且没有自己的`this`，`arguments`，`super`或`new.target`。***箭头函数表达式更适用于那些本来需要匿名函数的地方***，并且它不能用作构造函数。箭头函数也称之为lambda表达式，在java，c#等语言中都有类似的语法

## 闭包

闭包（closure）是多个语言都有的一个特性，闭包让你可以在一个内层函数中访问到其外层函数的作用域。闭包是一个捕获了其作用域链上本该被销毁的变量的函数（陈军说的）

### 什么是闭包

本来一个函数中声明的变量，在函数执行完毕之后是不能访问的。比如下面的代码.变量a只在函数f中生效

```js
function f() {
    var a = 100
    console.log('在函数f内部可以:', a)
}
f()
//这里是不能访问函数f中的变量的，因为函数作用域的问题
console.log(a) */
```

但是如果你像下面这样编写代码,会导致变量aa被匿名函数所引用，并且匿名函数跳出了f2的范围，匿名函数执行的时机是在f2执行完毕之后才执行

```js
function f2() {
    var aa = 1000
    return function () {
        console.log(aa)
    }
}

let result = f2() //result是一个函数
result()
```

### 闭包引起的问题

```html
<ul>
    <li>111</li>
    <li>222</li>
    <li>333</li>
</ul>
```

```js
let allLi = document.querySelectorAll('li')

for (var i = 0; i < allLi.length; i++) {
    allLi[i].addEventListener('click', function () {
        console.log(i) //会输出3
        alert(allLi[i].innerHTML)
    })
}

```

会出错，这是因为

- var声明的变量会提升,所以每个事件处理函数用的是同一个变量
- 循环结束后i等于3
- 3个事件处理函数会捕获同样的变量i。i等于3，找不到对应的li所以是undefined，访问一个undefined类型的innerHTML属性当然会报错

### 闭包的常见用法

#### 全局唯一编号

```js
let generator = (function () {
    let i = 10000
    return function () {
        i++
        return i
    }
})()
console.log(generator())
console.log(generator())
```



#### 属性

```js
let getterSetter = (function () {
    let age = 0

    return {
        setAge: function (value) {
            if (value < 0 || value > 120) {
                //这里throw new Error更好
                console.log('超出范围')
                age = 0
            } else {
                age = value
            }
        },
        getAge: function () {
            return age
        },
    }
})()

getterSetter.setAge(10)
console.log(getterSetter.getAge())

getterSetter.setAge(-10)
console.log(getterSetter.getAge())
```



#### 缓存

```js
let userService = (function () {
    let cached = new Map()

    return {
        getById: function (id) {
            if (cached.has(id)) {
                console.log('查快速的东西')
                return cached.get(id)
            } else {
                //查数据库
                console.log('查慢速的东西')
                let value = Math.random()
                cached.set(id, value)
                return value
            }
        },
    }
})()

let result = userService.getById(100)
console.log('1:', result)

let result2 = userService.getById(100)
console.log('2:', result2)

let result3 = userService.getById(200)
console.log('1:', result3)
```



### 闭包的性能考量

不要烂用闭包，因为闭包会使得一个执行完毕的局部变量长期驻留在内存中，会消耗更多内存，可能导致内存泄漏。一个简单的解决办法就是退出函数之前，将不适用的局部变量全部删除。

如果不是某些特定任务需要使用闭包，在其它函数中创建函数是不明智的，因为闭包在处理速度和内存消耗方面对脚本性能具有负面影响。

例如，在创建新的对象或者类时，方法通常应该关联于对象的原型，而不是定义到对象的构造器中。原因是这将导致每次构造器被调用时，方法都会被重新赋值一次（也就是说，对于每个对象的创建，方法都会被重新赋值）。

考虑以下示例：

```js
function MyObject(name, message) {
  this.name = name.toString();
  this.message = message.toString();
  this.getName = function() {
    return this.name;
  };

  this.getMessage = function() {
    return this.message;
  };
}
```

在上面的代码中，我们并没有利用到闭包的好处，因此可以避免使用闭包。修改成如下：

```js
function MyObject(name, message) {
  this.name = name.toString();
  this.message = message.toString();
}
MyObject.prototype = {
  getName: function() {
    return this.name;
  },
  getMessage: function() {
    return this.message;
  }
};
```

但我们不建议重新定义原型。可改成如下例子：

```js
function MyObject(name, message) {
  this.name = name.toString();
  this.message = message.toString();
}
MyObject.prototype.getName = function() {
  return this.name;
};
MyObject.prototype.getMessage = function() {
  return this.message;
};
```

在前面的两个示例中，继承的原型可以为所有对象共享，不必在每一次创建对象时定义方法

# 对象的创建与使用

***对象是数据与行为的一个封装***

## 对象创建方法

js中的对象通过下面3种形式创建出来

- 对象字面量（Object literal）
- 构造型函数创建出来
- 通过es6的class创建出来

关于第三种，会放在下一章详细讲解，本章侧重前两种方法

### 对象字面量创建对象

```js
//创建了一个“空”的对象
let o = {}

//接着利用js的动态特性，运行时随时随地给对象添加新的成员（member）
o.name="abc"
o.work = function(){
    console.log("我在工作");
}

let name = o.name
o.work()
```



### 构造型函数创建对象

```js
//什么叫构造型函数：其实就是一个普通的函数
//我们人为的把其当成一个可以创建出新的对象出来的函数用
//特点：首字母大写

function Person() {}
let p1 = new Person()
//人为禁止像下面这样直接调用。
//Person()

//添加属性与方法
//可以给p1这个对象动态添加成员
p1.name = 'abc'

let p2 = new Person()
//输出undefined，因为p2这个对象没有name属性
console.log(p2.name)

function Student() {
    this.name = '乳名'
    this.work = function () {
        console.log('我在工作')
    }
}
let s1 = new Student()

console.log(s1.name)
/*
      够造型函数创建对象的逻辑过程
      1.new Xxx
      2.在够造型函数内部直接创建一个空的对象，
      可以把其理解为对象字面量 o = {}
      3.接着把这个对象o  === this
      4.不断的利用js的动态特性给this这个对象添加新的成员，比如name
      5.返回this
      */

let s2 = new Student()
console.log(s2.name)
```

除了把函数当类来看待，也可以把其当成类似java种的构造函数看待

```js
function Person(name){
    this.name = name
}
let p1 = new Person("张三")
console.log(p1.name) //输出张三
let p2 = new Person("李四")
console.log(p2.name) //输出李四 
```



### class创建对象

```js
class Student {}
let s1 = new Student()
```



### constructor

对象字面量的构造器与通过构造函数创建得对象的构造器。

```js
//构造器（constructor）指的是对象的创建者
//找到亚当夏娃的创造者也就是上帝

function Person() {}
let p1 = new Person()
//输出的就是Person函数
console.log(p1.constructor)

let o1 = {}
//输出的就是Object
console.log(o1.constructor)

console.log(o1.constructor === Object)
console.log(p1.constructor === Person)
//constructor是一个指代Object函数的东西，
//所以（）这样调用的时候就是创建了一个对象
let o2 = o1.constructor()
//因为o1与o2都是构造器Object创建出来的，所以下面的等式就成立
console.log(o2.constructor === o1.constructor)
```

通过上面的案例代码知道，对象字面量的构造器是Object，其实对象字面量等价于new Object

```js
let o = {}
//等价于下面的代码
let o = new Object()
```



> 所有函数的constructor最终的constructor都是Function，Function自己的constructor也是Function本身

## 属性

给对象添加属性有三种方法

- 利用动态性直接添加
- es6推出的简便写法
- 利用Object.defineProperty之类的方法添加

### 数据属性

```js
let o = {
    name: 'a',
}
let age = 18

let o2 = {
    name: 'a',
    age: age,
}

```

如果想让对象的属性名与变量一样，可以简写为下面的形式

```js

//简便的写法,下面的age属性是：变量名是属性名，变量值是属性值
let o3 = {
    name: 'a',
    age,
}

let gender = true
let height = 180
let o4 = {
    gender,
    height,
}
console.log(o4.gender) //true
console.log(o4.height) //180
```

上面声明属性的方式不能对属性进行进一步的控制，比如让其不可写等。但通过Object.defineProperty方法是可以做到对属性进行进一步的控制，比如下面的代码

```js
let o5 = {
    name: 'a',
}

//给o5这个对象添加属性，并且此属性自己有一些特性，比如不可写

Object.defineProperty(o5, 'bj', {
    writable: false,
    value: '164ban',
})
console.log(o5.bj)
o5.bj = '163'//改写不会成功
console.log('改写之后:', o5.bj)  //仍然输出164ban
```

属性特性主要的配置项有如下一些

- configurable
  当且仅当该属性的 configurable 键值为 true 时，该属性的描述符才能够被改变，同时该属性也能从对应的对象上被删除。
  默认为 false。
- enumerable
  当且仅当该属性的 enumerable 键值为 true 时，该属性才会出现在对象的枚举属性中。
  默认为 false。
- value
  该属性对应的值。可以是任何有效的 JavaScript 值（数值，对象，函数等）。
  默认为 undefined。
- writable
  当且仅当该属性的 writable 键值为 true 时，属性的值，也就是上面的 value，才能被赋值运算符改变。
  默认为 false。
- get
  属性的 getter 函数，如果没有 getter，则为 undefined。当访问该属性时，会调用此函数。执行时不传入任何参数，但是会传入 this 对象（由于继承关系，这里的this并不一定是定义该属性的对象）。该函数的返回值会被用作属性的值。
  默认为 undefined。
- set
  属性的 setter 函数，如果没有 setter，则为 undefined。当属性值被修改时，会调用此函数。该方法接受一个参数（也就是被赋予的新值），会传入赋值时的 this 对象。
  默认为 undefined。



### 访问器属性

普通属性无法对其赋值逻辑进行控制，而访问器属性是可以的，访问器属性类似于java中getter，setter，访问器属性有2种方法来创建

- defineProperty
- es6出现的简写形式，此方式专门针对对象字面量有效



**Object.defineProperty**

```js
let o = {
    _age: 0,
}
//虽然外部可以直接访问，但我们人为规定不能这样使用
o._age = 10000
Object.defineProperty(o, 'age', {
    get: function () {
        return this._age
    },
    set: function (val) {
        if (val <= 0 || val >= 120) {
            throw new Error('超出范围')
        }
        this._age = val
    },
})

//o.age = 180
//console.log(o.age)
//可以绕过规则，但不要这样做。
o._age = 200
console.log(o.age)
```

**简写形式**

这种形式是es6之后新推出的，只在对象字面量里生效

```js
//第二种方法
let o2 = {
    _xxx: 0,
    get age() {
        return this._xxx
    },
    set age(val) {
        if (val <= 0 || val >= 120) {
            throw new Error('超出范围2')
        }
        this._xxx = val
    },
}
//注意：声明的时候像是方法，但是它毕竟是属性，所以不要加括号
o2.age = 23
console.log(o2.age)
```



### 静态属性

关于对象字面量，其属性没有静态这一说法，静态属性此说法主要是针对当成类来使用的js对象，也就是构造型函数和class。关于class中的静态属性在下一章会讲，本章主要重点关注构造型函数的静态属性写法

```js
function Person(){
    
}
//因为Person虽然是个函数，但也是对象，利用js的动态性，可以添加属性
Person.canUseTools = true
//仔细看下面2行代码，是不是canUseTools属性像java中类的静态属性
let p1 = new Person()
let id = Person.canUseTools
```

举个例子，jQuery的each，trim等等方法都可以认为是jQuery类的静态方法

## 方法

### 普通定义

```js
let o = {
    m1: function (s) {
        console.log(s)
    }
}
o.m1('m1')
```

### ES6定义

这种简写形式主要用在对象字面量声明的时候

```js
let o = {
    m2(s) {
        console.log(s)
    },
}
o.m1('m2')
```

在构造型函数中是没法用这个简写形式的，比如下面的代码会报错

```js
function Person(){
    this.m3(){

    }
}
```



### 静态方法

此方法是属于够造型函数与class的。添加的方式与前面讲的类似，比如下面的代码

```js
function Person(){
    
}
//报错，没有这种简写形式
Person.xxx(){}
//没有参数
Person.yyy = function(){
    
}
//有参数
Person.yyy = function(x){
    
}
```



## 成员访问

```js
let obj = { name: 'abc', 0: 'def', 'a b': 100 }

//访问对象的成员方法一：用点号
//o.name
//像数字和空格的特殊是不能用点访问的。

//方法二：用中括号
//obj[0]
//obj["a b"]

//方法三：表达式 （ES的新的语法，以前是不支持表达式写法
let x = 'a'
console.log(obj[x + ' b']) //输出100
```



### 对象解构

就是把对象中的值按规则取出后赋值给变量，方便从对象中取值，主要有以下几种使用场景

- 变量名与属性名同名

```js
let obj = { name: 'abc', age: 18, height: 185 }

let { age, height } = obj
console.log(age, height)
```

- 变量名与属性名不同名

```js
let obj = { name: 'abc', age: 18, height: 185 }
//冒号右边是变量名
let { age, height: h } = obj
```

- 属性允许重复使用

```js
let { age, height: h, age: myAge } = obj
console.log(age, h, myAge)
```

- 与rest配合使用

```js
let { age, ...myObj } = obj
console.log(age, myObj.name, myObj.height)
```



### 对象展开

下面的代码类似于jQuery中的extend方法，同名属性会覆盖，所以最终结果对象o3中name属性的值是def

```js
let o1 = { name: 'abc', age: 18 }
let o2 = { name: 'def', gender: true }
let o3 = { ...o1, ...o2 } //name:def,gender:true,age:18
```

## this

与其他语言相比，**函数的 `this` 关键字**在 JavaScript 中的表现略有不同，此外，在[严格模式](https://developer.mozilla.org/zh-CN/docs/Web/JavaScript/Reference/Strict_mode)和非严格模式之间也会有一些差别。

***在绝大多数情况下，函数的调用方式决定了 `this` 的值（运行时绑定）。***

> `this` 不能在执行期间被赋值，并且在每次函数被调用时 `this` 的值也可能会不同。ES5 引入了 [bind](https://developer.mozilla.org/zh-CN/docs/Web/JavaScript/Reference/Global_Objects/Function/bind) 方法来设置函数的 `this` 值，而不用考虑函数如何被调用的。ES2015 引入了[箭头函数](https://wiki.developer.mozilla.org/zh-CN/docs/Web/JavaScript/Reference/Functions/Arrow_functions)，箭头函数不提供自身的 this 绑定（`this` 的值将保持为闭合词法上下文的值）
>
> https://developer.mozilla.org/zh-CN/docs/Web/JavaScript/Reference/Operators/this

在箭头函数出现之前，每一个新函数根据它是被如何调用的来定义这个函数的this值：

- 如果是该函数是一个构造函数，this指针指向一个新的对象
- 在严格模式下的函数调用下，this指向undefined
- 如果是该函数是一个对象的方法，则它的this指针指向这个对象
- 等等

```js
// const o = {
//   x: 42,
//   getX: function () {
//     return this.x
//   },
// }

// const f = o.getX
// console.log(f()) 
// o.getX()
```

### 全局调用中的this

```js
// 在浏览器中, window 对象同时也是全局对象：
console.log(this === window); // true

a = 37;
console.log(window.a); // 37

function f(){return this.a}
console.log(window.f)  // 输出函数f
```



### 对象调用中的this

```js
var o = {
  prop: 37,
  f: function() {
    return this.prop;
  }
};

console.log(o.f()); // 37
```

如果把上面的代码改为下面的形式，那么f函数的this就指向全局对象（window）

```js
var prop = 100 //用var声明才会变成window对象的成员
var o = {
  prop: 37,
  f: function() {
    return this.prop;
  }
};
let foo = o.f
console.log(foo()); // 100
```

### 事件处理函数中的this

事件处理函数中的this指的就是引发此事件的元素

```js
var elements = document.getElementsByTagName('p');

for(let i=0 ; i<elements.length ; i++){
  elements[i].addEventListener('click', function(){console.log(this)}, false);
}
```

### 箭头函数中的this

在箭头函数出现之前，每一个新函数根据它是被如何调用的来定义这个函数的this值：

- 如果是该函数是一个构造函数，this指针指向一个新的对象
- 在严格模式下的函数调用下，this指向undefined
- 如果是该函数是一个对象的方法，则它的this指针指向这个对象

`This`被证明是令人厌烦的面向对象风格的编程。

箭头函数不会创建自己的`this,它只会从自己的作用域链的上一层继承this`。因此，在下面的代码中，传递给`setInterval`的函数内的`this`与封闭函数中的`this`值相同：

```js
function Person(){
  this.age = 0;

  setInterval(() => {
    this.age++; // |this| 正确地指向 p 实例
  }, 1000);
}

var p = new Person();
```

下面的vue代码片段就可以看到this的处理代码

```js
let vm = new Vue({
    el: '#app',
    data() {
        return { active: 0, products: [] }
    },
    created() {
        this.getProductList()
    },

    methods: {
        getProductList() {
            var that = this
            $.getJSON('http://localhost:8080/exam_be/product/list', function (data) {
                //不能用this，这里的this指的不是vm对象，
                //下面的that可以换成vm变量，这样就不用管this指向问题了
                //lambda表达式也是可以的
                that.products = data

                that.products.forEach((item, index) => {
                    item.oPrice = (item.price * (1 + Math.random())).toFixed(2)
                })
                console.log(that.products)
            })
        },
    },
})
```



### bind

ECMAScript 5 引入了 [`Function.prototype.bind()`](https://developer.mozilla.org/zh-CN/docs/Web/JavaScript/Reference/Global_Objects/Function/bind)。调用`f.bind(someObject)`会创建一个与`f`具有相同函数体和作用域的函数，但是在这个新函数中，`this`将永久地被绑定到了`bind`的第一个参数，无论这个函数是如何被调用的。

```js
function f(){
  return this.a;
}
//1.bind方法是函数独有的一个方法
//2.bind返回的是一个新的函数
//3.bind的参数是要绑定的this的值
var g = f.bind({a:"azerty"});
//下面这样调用，本来this是指向window的。
// --->但由于是bind生成的，this仍然指向{a:"azerty"}
console.log(g()); // azerty

// *注意*：下面是用g这个函数调用bind
var h = g.bind({a:'yoo'}); // bind只生效一次！
//如果改为下面这样，bind仍然生效，也就说不能在bind结果函数上再进行绑定
//var h = f.bind({a:'yoo'});
console.log(h()); // azerty

var o = {a:37, f:f, g:g, h:h};
console.log(o.a, o.f(), o.g(), o.h()); 
// 37, 37, azerty, azerty
```



> `bind()` 的另一个最简单的用法是使一个函数拥有预设的初始参数。只要将这些参数（如果有的话）作为 `bind()` 的参数写在 `this` 后面。当绑定函数被调用时，这些参数会被插入到目标函数的参数列表的开始位置，传递给绑定函数的参数会跟在它们后面
>
> **偏函数**
>
> ```js
> function addArguments(arg1, arg2) {
>  return arg1 + arg2
> }
> // 创建一个函数，它拥有预设的第一个参数
> var addThirtySeven = addArguments.bind(null, 37)
> 
> // 37 + 5 = 42
> var result1 = addThirtySeven(5)
> 
> // 37 + 5 = 42 ，第二个参数被忽略
> var result2 = addThirtySeven(5, 10)
> 
> console.log(result1, result2)
> ```
>
> 

### apply与call

```js
function add(c, d) {
  return this.a + this.b + c + d;
}

var o = {a: 1, b: 3};
// 第一个参数是用作“this”的对象
// 其余参数用作函数的参数
add.call(o, 5, 7); // 16

// 第一个参数是用作“this”的对象
// 第二个参数是一个数组，数组中的两个成员用作函数参数
add.apply(o, [10, 20]); // 34
```



把一个有length属性的对象变成一个数组，实现代码如下：

```js
let o = { 0: 'abc', 1: 'def', length: 2 }
let arr = Array.prototype.slice.call(o)
console.log(arr) // [abc,def]
console.log(arr[0]) // abc
console.log(arr[1]) // def
```

> 这种用法在jQuery中有使用，jQuery的包装集就是一个数组型对象
>
> 数组的slice代码实现类似于：
>
> ```js
> function slice(start, end) {
>  var array = [];
>  start = start ? start : 0;
>  end = end ? end : this.length;
> 
>  for (var i = start, j = 0; i < end; i++, j++) {
>      array[j] = this[i];
>  }
>     
> 
>  return array;
> ```
>
> 



## Object

### defineProperty

```js
let o ={}
Object.defineProperty(o,"xxx",{
    configurable:true,
    enumerable:true,
    writable:true,
    value:100,
    get:function(){},
    set:function(val){  
})
```

### hasOwnProperty

`**hasOwnProperty()**` 方法会返回一个布尔值，指示对象自身属性中是否具有指定的属性（也就是，是否有指定的键）。

```js
let o = { name: 'abc' }
console.log(o.hasOwnProperty('name')) //true
console.log(o.toString())
console.log(o.hasOwnProperty('toString')) //false
```



### propertyIsEnumerable

```js
let o = { name: 'abc' }

Object.defineProperty(o, 'age', {
    enumerable: false,
    writable: true,
    value: 18,
})

console.log(o.propertyIsEnumerable('name'))
console.log(o.propertyIsEnumerable('age'))
```



### entries

`**Object.entries()**`方法返回一个给定对象自身可枚举属性的键值对数组，其排列与使用 [`for...in`](https://developer.mozilla.org/zh-CN/docs/Web/JavaScript/Reference/Statements/for...in) 循环遍历该对象时返回的顺序一致（区别在于 for-in 循环还会枚举原型链中的属性）。

```js
const object1 = {
  a: 'somestring',
  b: 42
};
//这里有一个数组的解构运算，因为entries返回的是一个数组的数组
for (const [key, value] of Object.entries(object1)) {
  console.log(`${key}: ${value}`);
}
```

### keys

`**Object.keys()**` 方法会返回一个由一个给定对象的自身可枚举属性组成的数组，数组中属性名的排列顺序和正常循环遍历该对象时返回的顺序一致 。

```js
// simple array
var arr = ['a', 'b', 'c'];
console.log(Object.keys(arr)); // console: ['0', '1', '2']

// array like object
var obj = { 0: 'a', 1: 'b', 2: 'c' };
console.log(Object.keys(obj)); // console: ['0', '1', '2']

let o = { name: 'abc' }
console.log(Object.keys(o)) //["name"]
```



### values

`**Object.values()**`方法返回一个给定对象自身的所有可枚举属性值的数组，值的顺序与使用[`for...in`](https://developer.mozilla.org/zh-CN/docs/Web/JavaScript/Reference/Statements/for...in)循环的顺序相同 ( 区别在于 for-in 循环枚举原型链中的属性 )。

```js
var obj = { foo: 'bar', baz: 42 };
console.log(Object.values(obj)); // ['bar', 42]

// array like object
var obj = { 0: 'a', 1: 'b', 2: 'c' };
console.log(Object.values(obj)); // ['a', 'b', 'c']

// array like object with random key ordering
// when we use numeric keys, the value returned in a numerical order according to the keys
var an_obj = { 100: 'a', 2: 'b', 7: 'c' };
console.log(Object.values(an_obj)); // ['b', 'c', 'a']
```





### preventExtensions 和isExtensible

`**Object.preventExtensions()**`方法让一个对象变的不可扩展，也就是永远不能再添加新的属性。

```js
// Object.preventExtensions将原对象变的不可扩展,并且返回原对象.
var obj = {};
var obj2 = Object.preventExtensions(obj);
obj === obj2;  // true
 
// 字面量方式定义的对象默认是可扩展的.
var empty = {"name":"abc"};
Object.isExtensible(empty) //=== true
 
// ...但可以改变.
Object.preventExtensions(empty);
Object.isExtensible(empty) //=== false
Object.defineProperty(empty,"name",{enumerable:false})
// 使用Object.defineProperty方法为一个不可扩展的对象添加新属性会抛出异常.
var nonExtensible = { removable: true };
Object.preventExtensions(nonExtensible);
Object.defineProperty(nonExtensible, "new", { value: 8675309 }); // 抛出TypeError异常
 
// 在严格模式中,为一个不可扩展对象的新属性赋值会抛出TypeError异常.
function fail()
{
  "use strict";
  nonExtensible.newProperty = "FAIL"; // throws a TypeError
}
fail();
```



### seal与isSealed

`**Object.seal()**`方法封闭一个对象，阻止添加新属性并将所有现有属性标记为不可配置。当前属性的值只要原来是可写的就可以改变属性的值。

```js
const object1 = {
  property1: 42
};

Object.seal(object1);
object1.property1 = 33; //密封之后，可以改变属性的值
console.log(object1.property1);
// expected output: 33

delete object1.property1; // 密封之后不能删除
console.log(object1.property1);

//下面直接抛出异常：TypeError: Cannot redefine property: name
Object.defineProperty(object1, 'property1', {
    enumerable: false,
})
```



### freeze与isFrozen()

`**Object.isFrozen()**`方法判断一个对象是否被[冻结](https://developer.mozilla.org/zh-CN/docs/Web/JavaScript/Reference/Global_Objects/Object/freeze)。

一个对象是冻结的是指它不可[`扩展`](https://developer.mozilla.org/zh-CN/docs/Web/JavaScript/Reference/Global_Objects/Object/isExtensible)，所有属性都是不可配置的，且所有数据属性（即没有getter或setter组件的访问器的属性）都是不可写的。

```js
var frozen = { 1: 81 };
Object.isFrozen(frozen) //=== false
Object.freeze(frozen);
Object.isFrozen(frozen) //=== true
frozen[1]=99 //这行代码运行不报错，但是修改不成功
console.log(frozen[1])// 仍然输出81，属性值冻结后不能修改了。
```

> preventExtensions，seal，freeze的重要区别：
>
> - preventExtensions 不可添加新属性，但可以配置原本的属性
> - seal：不可添加属性，也不可以配置原本的属性，属性的值如果原本就可写，那么值仍然可以改变
> - freeze：不可添加新属性，不可配置原本的属性，数据属性的值也不可以改变

### is

`**Object.is()**` 方法判断两个值是否为[同一个值](https://developer.mozilla.org/zh-CN/docs/Web/JavaScript/Equality_comparisons_and_sameness)。

`Object.is()` 方法判断两个值是否为[同一个值](https://developer.mozilla.org/zh-CN/docs/Web/JavaScript/Equality_comparisons_and_sameness)。如果满足以下条件则两个值相等:

- 都是 [`undefined`](https://developer.mozilla.org/zh-CN/docs/Web/JavaScript/Reference/Global_Objects/undefined)

- 都是 [`null`](https://developer.mozilla.org/zh-CN/docs/Web/JavaScript/Reference/Global_Objects/null)

- 都是 `true` 或 `false`

- 都是相同长度的字符串且相同字符按相同顺序排列

- 都是相同对象（意味着每个对象有同一个引用）

- 都是数字且

  - 都是 `+0`
  - 都是 `-0`
  - 都是 [`NaN`](https://developer.mozilla.org/zh-CN/docs/Web/JavaScript/Reference/Global_Objects/NaN)
  - 或都是非零而且非 [`NaN`](https://developer.mozilla.org/zh-CN/docs/Web/JavaScript/Reference/Global_Objects/NaN) 且为同一个值

  与[`==`](https://developer.mozilla.org/zh-CN/docs/Web/JavaScript/Reference/Operators/Comparison_Operators#Equality) 运算*不同。* `==` 运算符在判断相等前对两边的变量(如果它们不是同一类型) 进行强制转换 (这种行为的结果会将 `"" == false` 判断为 `true`), 而 `Object.is`不会强制转换两边的值。

  与[`===`](https://developer.mozilla.org/zh-CN/docs/Web/JavaScript/Reference/Operators/Comparison_Operators#Identity) 运算也不相同。 `===` 运算符 (也包括 `==` 运算符) 将数字 `-0` 和 `+0` 视为相等 ，而将[`Number.NaN`](https://developer.mozilla.org/zh-CN/docs/Web/JavaScript/Reference/Global_Objects/Number/NaN) 与[`NaN`](https://developer.mozilla.org/zh-CN/docs/Web/JavaScript/Reference/Global_Objects/NaN)视为不相等.

  ```js
  let o5 = { name: 'abc' }
  let o6 = { name: 'abc' }
  let o7 = o5
  console.log('o5 is o6:', Object.is(o5, o6))
  console.log('o5 is o7:', Object.is(o5, o7))
  o7.name = 'def'
  console.log('o5 is o7:', Object.is(o5, o7))
  ```

  

# 类

在es6中推出用class关键字声明的类的写法，可以取代老的prototype写法，其基本特点有如下几个

- class只是语法糖，本质还是一个构造型函数
- 类的所有实例方法定义在类的prototype属性中
- 使用class定义的类不具有提升特性，而构造函数有提升特性
- 类中的代码强制运行在严格模式下，无法退出严格模式
- 类中定义的方法不可枚举
- 类默认都拥有constructor构造函数

## 类的创建

es6推出的类的创建，主要有两种方法

- 类声明
- 类表达式的形式

```js
//声明形式的类创建方法
class Person{

}
let p1 = new Person()
//匿名类的表达式声明形式
let Person  = class {}
//有名字的类表达式的声明形式
let Person = class Person2{

}
```

es6 class的特点有如下一些

- class只是语法糖（syntax sugar），class定义的本质还是一个构造函数
- 类的所有实例方法定义在类的原型中（prototype）
- 使用class定义的类不具有提升（Hoisting）特性
- 类中的代码强制运行在严格模式下，无法退出
- 在类中定义的方法不可枚举
- 类默认拥有构造方法

## 构造函数

js中的构造函数有如下特点

- 方法名为constructor
- 每个类都有一个默认的空构造方法
- 构造方法默认返回this，不建议改变返回对象
- 一个类只能定义一个构造方法，没有重载
- 构造函数的参数可以有也可以没有

写法如下：

```js
class Person {
    constructor(name) {
        this.name = name
    }
}
let p1 = new Person('hello')
console.log(p1.name)
```

理解es6 类的实例的创建

- 创建一个空对象{}
- 创建this，并赋值为上一步的空对象
- 执行构造函数
  - 动态给对象添加一个name属性（上面的案例）
- 返回这个空对象，也就是this

```js
let p1 = new Person('hello')
console.log(p1.name)

let p2 = new Person('hello')
p2.name = 'hello2'
//p1的name与p2的name是独立的，互相不影响
console.log(p1.name, p2.name)//输出hello，hello2
```

## 字段

### 实例字段

实例字段是每个对象独有的，相互之间不影响，定义时不需要关键字声明，如果不指定值则默认为undefined，实例字段可以理解为数据属性，实例字段要用对象来访问

```js
class Person {
   age = 18 //实例字段，不要用let，const之类的东西修饰
}
 console.log(p1.age) //输出18，意味着字段是公有的
console.log(Person.age) //undefined
```



### 静态字段

静态字段要用类来访问

```js
static class Person {
    age = 18 //实例字段，不要用let，const之类的东西修饰
}
console.log(p1.canUseTools) //输出undefined
console.log(Person.canUseTools) //输出true
```

## 属性

在es6中属性就只有getter，setter的写法，普通的数据属性，就用字段来编写

### 实例属性

```js
get age() {
    return this.age
}
set age(val) {
    this.age = val
}
let p1 = new Person('hello')
p1.age = 22
console.log(p1.age)

```



### 静态属性

```js
static get canUserTools() {
    return true
}
console.log(Person.canUseTools)
```



## 方法

### 实例方法

```js
work(){
    console.log("我在工作")
}

add(a,b){
    return a + b
}
p1.work()
console.log(p1.add(10, 20))
```



### 静态方法

```js
static eat() {
    console.log('chi....')
}
 Person.eat()
```



# OOP特性实现

OOP的三大特性是

- 封装
- 继承
- 多态

## 封装

从大到小，这些内容都可以认为是封装

- 分成一个个的js文件,也就是模块化
- js文件中的一个个普通函数、对象、构造型函数
- 属性
  - 访问器属性
  - 闭包实现的私有字段实现
- 方法

### 命名空间实现

命名空间也称之为包。

```js
let java = {}
java.util = {}
java.util.ArrayList = function(){}

let al = new java.util.ArrayList()
```



## 继承

继承主要是针对对象而言的，从本质上来说，继承就是把别的对象的东西变成自己的。逻辑上来说，只有2种方法把别人的变成自己的

- 把别的对象的东西复制到本对象
- 把别的对象的东西跟自己建立连接，当调用一个自己没有的成员时，回去找连接的对象，看它有没有

### 复制的方式(mixin)

`**Object.assign()**` 方法用于将所有可枚举属性的值从一个或多个源对象分配到目标对象。它将返回目标对象。

```js
const target = { a: 1, b: 2 };
const source = { b: 4, c: 5 };

const returnedTarget = Object.assign(target, source);

console.log(target);
// expected output: Object { a: 1, b: 4, c: 5 }

console.log(returnedTarget);
// expected output: Object { a: 1, b: 4, c: 5 }
```

> 在早期的jQuery中的extend方法其实就是通过复制的方式来实现继承的

### call与apply方式实现继承

在一个子构造函数中，你可以通过调用父构造函数的 `call` 方法来实现继承。下例中，使用 `Food` 和 `Toy `构造函数创建的对象实例都会拥有在 `Product` 构造函数中添加的 `name` 属性和 `price` 属性,但 `category` 属性是在各自的构造函数中定义的。

```js
function Parent(name, age) {
    this.name = name
    this.age = age
}

function Child(name, age) {
    Parent.call(this, name, age)
    this.c1 = 'c1'
}

function Child2(name, age) {
    Parent.apply(this, [name, age])
    this.c2 = 'c2'
}

let c1 = new Child('aaa', 18)
let c2 = new Child2('bbb', 19)
console.log(c1)
console.log(c2)
```



### prototype方式

```js
function Emp(name) {
    this.name = name
}
Emp.prototype.work = function () {
    console.log('原型中的this指向：', this) //指向的是创建出来的对象，比如下面的e1
    console.log(this.name + ' 在编程')
}
let e1 = new Emp('emp 1')
let e2 = new Emp('emp 2')
e1.work()

console.log(Emp.prototype)
console.log(Emp.prototype.constructor === Emp)
console.log(e1.__proto__)
console.log(e1.__proto__ === Emp.prototype)
console.log(e2.__proto__ === Emp.prototype)
```

尽量把对象公共的内容，比如方法都放到原型对象上，这样可以避免每个new出来的对象都额外添加新的成员。

因为所有对象都会从它的原型上继承一个 `constructor` 属性，所以改变一个对象的prototype时，通常情况下要求也修正其constructor属性值

```js
function Person(name){
    this.name = name;
}
Person.prototype = {};// 清空prototype
Person.prototype.sayHello = function(){alert(this.name+"say Hello!");};
console.log(ming.constructor == Person) //false
console.log(ming.constructor == Object) //true
```

从语义上来说ming这个对象的构造器应该是Person才对，所以改变了Prototype属性之后最好修正constructor的值。

```js
Person.prototype.constructor = Person
```



#### 扩展原生对象

> https://www.cnblogs.com/simonryan/p/4828791.html ,此文有说明原生对象与内置对象的区别
>
> https://blog.csdn.net/wp270280522/article/details/45723993 此文有说明扩展原生对象的方法

不要这样扩展：因为它默认是可配置，可枚举的，这样添加之后反射循环时就会出现这个新添加的成员，这通常不是所期望的情况。

```js
Array.prototype.method = function(){
    console.log('I am an user defined method!');
}

var a = [];
a.method();
```

建议下面这样扩展

```js
Object.defineProperty(Array.prototype,'method',{
    writable:false,
    enumerable:false,
    configurable:true, 
    value:function(){
        console.log('I am an user defined method!');
    }
});
```

> 注意：上面value赋值为一个函数，而不是一个简单的值

下面的代码就给数组添加了一个first方法，用来返回数组中的第一个元素

```js
/*
如果JavaScript本身不提供 first() 方法，
添加一个返回数组的第一个元素的新方法。
*/ 

if(!Array.prototype.first) {
    Array.prototype.first = function() {
        console.log(`如果JavaScript本身不提供 first() 方法，
添加一个返回数组的第一个元素的新方法。`);
        return this[0];
    }
}
```



### Object.create()

**`Object.create()`**方法创建一个新对象，使用现有的对象来提供新创建的对象的__proto__。 （请打开浏览器控制台以查看运行结果。）

```js
const person = {
  isHuman: false,
  printIntroduction: function() {
    console.log(`My name is ${this.name}. Am I human? ${this.isHuman}`);
  }
};

const me = Object.create(person);
me.name = 'Matthew'; // "name" is a property set on "me", but not on "person"
me.isHuman = true; // inherited properties can be overwritten

me.printIntroduction();
console.log(me.constructor === Object) //true
```



### es6类的继承

```js
class Person {}

class Student extends Person {

}
let s1 = new Student()
console.log(s1 instanceof Student)
console.log(s1 instanceof Person)
```

#### super

super指代的父对象

```js
class Person {
    work() {
        console.log('父类的方法')
    }
}

class Student extends Person {
    myWork() {
        super.work() // super就是指代父对象，this指的本对象
        console.log('我在工作')
    }
}

 s1.myWork() // 会输出：父类的方法 我在工作
```



#### 构造函数写法



```js
class Person {
    work() {
        console.log('父类的方法')
    }
}

class Student extends Person {
    constructor() {}
}
```

创建上面的类型之后，执行`let s1 = new Student()`就报错，错误信息如下：

```
VM31:8 Uncaught ReferenceError: Must call super constructor in derived class before accessing 'this' or returning from derived constructor
    at new Student (<anonymous>:8:16)
    at <anonymous>:1:10
```

这是因为子对象的构造函数中，必须调用父构造函数，如果你不写子类的构造函数，js引擎会自动帮你写上构造函数并且自动调用父类的构造函数,所以上面错误的解决办法就是

```js
class Person {
    work() {
        console.log('父类的方法')
    }
}

class Student extends Person {
    constructor() {
        super() // 必须是第一行代码
    }
}
```

在子类的构造函数中，必须在第一行里面写上`super()`以调用父类的构造函数

#### 静态成员继承

js与java，c#的继承的最大的不同就是父类的静态方法是可以被继承的。

```js
class Person {
    static Xxx() {
        console.log('父类的静态方法xxx')
    }
}

class Student extends Person {
}
Student.Xxx() //可以正常输出
```



## instanceof

> https://developer.ibm.com/zh/articles/1306-jiangjj-jsinstanceof/ 此文非常棒

在 JavaScript 中，判断一个变量的类型尝尝会用 typeof 运算符，在使用 typeof 运算符时采用引用类型存储值会出现一个问题，无论引用的是什么类型的对象，它都返回 “object”。

```js
let arr = [1,2,3]
let o ={}
console.log(typeof arr) //object
console.log(typeof o) //object
```



ECMAScript 引入了另一个 Java 运算符 instanceof 来解决这个问题。instanceof 运算符与 typeof 运算符相似，用于识别正在处理的对象的类型。与 typeof 方法不同的是，instanceof 方法要求开发者明确地确认对象为某特定类型

```js
var oStringObject = new String("hello world");
 console.log(oStringObject instanceof String);      // 输出 "true"
```

***instanceof运算符用于检测构造函数的 `prototype` 属性是否出现在某个实例对象的原型链上。***

```js
object instanceof constructor
```

比如下面示例

```js
function Car(make, model, year) {
  this.make = make;
  this.model = model;
  this.year = year;
}
const auto = new Car('Honda', 'Accord', 1998);

console.log(auto instanceof Car);
// expected output: true

console.log(auto instanceof Object);
// expected output: true
```



## 多态

多态有编译时多态与运行时多态这两种情况，编译时多态一般指的就是重载这种情况，而运行时多态就是在编译的时候还不确定要调用的是哪一个方法，只有在运行的时候才确定，一般会出现在“父类类型子类对象的情况”

### 重载





### 重写



## Object 



### getPrototypeOf



### setPrototypeOf



# 案例

## mini jQuery

```js
;(function () {
  var _$ = window.$
  var _jQuery = window.jQuery
  //暴露外部使用的一个接口
  var jQuery = (window.jQuery = window.$ = function (selector) {
    return new jQuery.fn.init(selector)
  })

  //处理原型对象
  jQuery.fn = jQuery.prototype = {
    init: function (selector) {
      var elements = document.querySelectorAll(selector)
      Array.prototype.push.apply(this, elements)
      return this
    },
    jQuery: '1.0.0',
    authro: 'cj',
    length: 0,
    size: function () {
      return this.length
    },
  }
  jQuery.fn.init.prototype = jQuery.fn
  //实现继承,并且只处理只有一个参数，也就是插件的扩展
  jQuery.extend = jQuery.fn.extend = function () {
    var o = arguments[0]
    for (var p in o) {
      this[p] = o[p]
    }
  }

  //添加静态方法
  jQuery.extend({
    trim: function (text) {
      return (text || '').replace(/^\s+|\s+$/g, '')
    },
    noConflict: function () {
      window.$ = _$
      window.jQuery = _jQuery
      return jQuery
    },
  })
  //添加实例方法

  jQuery.fn.extend({
    get: function (num) {
      return this[num]
    },
    each: function (fn) {
      for (var i = 0; i < this.length; i++) {
        fn(i, this[i])
      }
      return this
    },
    css: function () {
      var l = arguments.length
      if (l == 1) {
        return this[0].style[arguments[0]]
      } else {
        var name = arguments[0]
        var value = arguments[1]
        this.each(function (index, ele) {
          ele.style[name] = value
        })
      }
      return this
    },
  })
})()

```

使用

```html
<body>
    <ul>
        <li id="a">1</li>
        <li>2</li>
        <li class="test">3</li>
        <li>4</li>
        <li>5</li>
    </ul>
    <script src="./miniQuery.js"></script>

    <script>
        $('.test').css('background-color', 'red').css('font-size', '30px')
        // $('li').css('background-color', 'red').css('font-size', '30px')
    </script>
</body>
```



## mini vue

> https://www.cnblogs.com/libin-1/p/6893712.html

```js
//Observer
function Observer(data) {
    this.data = data;
    this.walk(data);
}

Observer.prototype = {
    walk: function(data) {
        var self = this;
        Object.keys(data).forEach(function(key) {
            self.defineReactive(data, key, data[key]);
        });
    },
    defineReactive: function(data, key, val) {
        var dep = new Dep();
        var childObj = observe(val);
        Object.defineProperty(data, key, {
            enumerable: true,
            configurable: true,
            get: function() {
                if (Dep.target) {
                    dep.addSub(Dep.target);
                }
                return val;
            },
            set: function(newVal) {
                if (newVal === val) {
                    return;
                }
                val = newVal;
                dep.notify();
            }
        });
    }
};

function observe(value, vm) {
    if (!value || typeof value !== 'object') {
        return;
    }
    return new Observer(value);
};

function Dep () {
    this.subs = [];
}
Dep.prototype = {
    addSub: function(sub) {
        this.subs.push(sub);
    },
    notify: function() {
        this.subs.forEach(function(sub) {
            sub.update();
        });
    }
};
Dep.target = null;

//watcher
function Watcher(vm, exp, cb) {
    this.cb = cb;
    this.vm = vm;
    this.exp = exp;
    this.value = this.get();  // 将自己添加到订阅器的操作
}

Watcher.prototype = {
    update: function() {
        this.run();
    },
    run: function() {
        var value = this.vm.data[this.exp];
        var oldVal = this.value;
        if (value !== oldVal) {
            this.value = value;
            this.cb.call(this.vm, value, oldVal);
        }
    },
    get: function() {
        Dep.target = this;  // 缓存自己
        var value = this.vm.data[this.exp]  // 强制执行监听器里的get函数
        Dep.target = null;  // 释放自己
        return value;
    }
};
//compiler
function Compile(el, vm) {
    this.vm = vm;
    this.el = document.querySelector(el);
    this.fragment = null;
    this.init();
}

Compile.prototype = {
    init: function () {
        if (this.el) {
            this.fragment = this.nodeToFragment(this.el);
            this.compileElement(this.fragment);
            this.el.appendChild(this.fragment);
        } else {
            console.log('Dom元素不存在');
        }
    },
    nodeToFragment: function (el) {
        var fragment = document.createDocumentFragment();
        var child = el.firstChild;
        while (child) {
            // 将Dom元素移入fragment中
            fragment.appendChild(child);
            child = el.firstChild
        }
        return fragment;
    },
    compileElement: function (el) {
        var childNodes = el.childNodes;
        var self = this;
        [].slice.call(childNodes).forEach(function(node) {
            var reg = /\{\{\s*(.*?)\s*\}\}/;
            var text = node.textContent;
            if (self.isTextNode(node) && reg.test(text)) {  // 判断是否是符合这种形式{{}}的指令
                self.compileText(node, reg.exec(text)[1]);
            }

            if (node.childNodes && node.childNodes.length) {
                self.compileElement(node);  // 继续递归遍历子节点
            }
        });
    },
    compileText: function(node, exp) {
        var self = this;
        var initText = this.vm[exp];
        this.updateText(node, initText);  // 将初始化的数据初始化到视图中
        new Watcher(this.vm, exp, function (value) { // 生成订阅器并绑定更新函数
            self.updateText(node, value);
        });
    },
    updateText: function (node, value) {
        node.textContent = typeof value == 'undefined' ? '' : value;
    },
    isTextNode: function(node) {
        return node.nodeType == 3;
    }
}

//self vue
function SelfVue (options) {
    var self = this;
    this.vm = this;
    this.data = options.data;

    Object.keys(this.data).forEach(function(key) {
        self.proxyKeys(key);
    });

    observe(this.data);
    new Compile(options.el, this.vm);
    return this;
}

SelfVue.prototype = {
    proxyKeys: function (key) {
        var self = this;
        Object.defineProperty(this, key, {
            enumerable: false,
            configurable: true,
            get: function proxyGetter() {
                return self.data[key];
            },
            set: function proxySetter(newVal) {
                self.data[key] = newVal;
            }
        });
    }
}


```

使用

```html
<body>
    <div id="app">
        <h2>{{ title }}</h2>
        <h1>{{ name }}</h1>
    </div>
</body>
<script src="js/observer.js"></script>
<script src="js/watcher.js"></script>
<script src="js/compile.js"></script>
<script src="js/index.js"></script>

<script type="text/javascript">

    var selfVue = new SelfVue({
        el: '#app',
        data: {
            title: 'hello world',
            name: ''
        }
    });

    window.setTimeout(function () {
        selfVue.title = '你好';
    }, 2000);

    window.setTimeout(function () {
        selfVue.name = 'canfoo';
    }, 2500);

</script>
```



# 模块化

近年来，有必要开始考虑提供一种将 JavaScript 程序拆分为可按需导入的单独模块的机制。Node.js 已经提供这个能力很长时间了，还有很多的 Javascript 库和框架 已经开始了模块的使用，开发者建立了很多的模块化规范与框架，但这些都只是替代方案，ES6模块化功能的出现才改变这一现状，下面是业界开发的一些模块化方案

- 浏览器端
  - AMD（异步模块规范）：RequireJs
  - CMD（普通模块规范）：SeaJs
- Node端： CommonJS（同步模块规范）
- 浏览器和Node端：UMD（通用模块规范）

好消息是，最新的浏览器开始原生支持模块功能了，这是本文要重点讲述的

## 浏览器端的简单使用

创建一个js文件，比如a.js

```js
export let number = 100
export function add(x,y){
    console.log(x+y)
}
```

创建一个html页面，在此页面以模块化的形式引入a.js文件

```html
<script type="module">
	import {add,number} from './a.js'
    add(number,200)
</script>
```

引用模块时，script的type值必须是module,并不是所有的浏览器都支持模块化，Chrome浏览器版本61以后才支持

> 关于模块文件的名字，有的是以js结尾，有的是以mjs结尾
>
> - 比较清晰，这可以指出哪些文件是模块，哪些是常规的 JavaScript。
> - 这能保证你的模块可以被运行时环境和构建工具识别，比如 [Node.js](https://nodejs.org/api/esm.html#esm_enabling) 和 [Babel](https://babeljs.io/docs/en/options#sourcetype)。

## ES6模块的特点

有如下一些特点：

- 运行在严格模式下，不管是否声明`"use strict"`并且没有任何退出方法，
- 一个模块一个文件
- 模块间可以相互依赖，A模块可以引用B模块，B模块可以引用A模块
- 模块的API是静态的，顶层内容导出之后不能被动态修改
- 模块都是单利，每一个模块只加载一次，只执行一次，如果下次再加载相同的文件，直接从内存中读取
- 每个模块内声明的变量都是局部变量，不会污染全局作用域，模块的顶层作用域的this值为undefined

## 模块导出（export）

导出的内容可以是变量、对象、函数、类或其它模块的内容，不导出内容的话外部是无法访问的

### 单独导出

```js
export let i = 100
export let j = 200
```

不能直接导出一个值，比如:`export 100`,因为外部没法访问这个值，所以***语法上是不允许这样直接导出值的***

### 集中导出

```js
let i = 100
let j = 200
export {i,j}
```

如果只有一个成员要导出，不能写成 `export i`（少了大括号），因为这样认为是一个导出声明

也支持单独导出与集中导出的混合

```js
export let i = 100
let j = 200
let add = function(){}
export {j,add}
```

### 重命名导出

```js
export let i = 100
let j = 200
let add = function(){}
export {j,add as plus}
```

这样外部只能以plus而不能用add访问此暴露的接口了。

## 模块导入

使用import指令完成模块导入，此指令会加载模块并将export导出的成员导入到本模块中。

假定被导入模块文件名是a.js代码如下：

```js
export let i = 100
const N = 200
let add = function(x,y){
    console.log(`x+y=${x+y}`)
}
export {N,add as plus}
```

导入时使用下面的代码

```js
import {i,N,plus} from './a.js'
plus(i,N)  //输出x+y=300
```

### 地址格式

导入模块文件时，路径的格式比如以下面3个开始

- /
- ./
- ../

***导入的成员必须与在导出模块中定义的名称一致，否则将报语法错误。***

### 导入重命名

```js
import {N,plus as sum} from './a.js'
sum(1,N)
```

### 命名空间导入

是使用*把所有导出成员归属到一个命名空间名字之上，之后利用命名空间名字来访问导入的成员

```js
import * as m from './a.js' //注意：这里是不能加大括号的
m.plus(m.i,m.N)
```



### 导入内容的不可修改性

待导出的内容

```js
export let i = 200
export let o ={age:18}
```

导入

```js
import {i,o} from './a.js'
i=300 //报错
o.age =22 //可以
o= {} //报错
```



### 多次导入的单例性



待导出的内容

```js
export let i = 200
export let o ={age:18}
console.log('ok---')
```

导入

```js
import {i,o} from './a.js'
import{i as j,o as p} from './a.js'
```

`ok---`的日志只会输出一次

## 默认导出导入

***每个模块允许默认导出一个成员***，导入时可以自定义对象名称，而不需要使用者过多关注被导入模块的细节，比如导出成员的名称。

待导出的内容

```js
function randomSquare(){}
export default randomSquare;
//或者
export default function() {
  ...
}
```

导入

```js
import randomSquare from './a.js'
//等价于
import {default as randomSquare} from './a.js'
```

当你导出一个变量时，要像下面这样编写

```js
export default 100
```

不能写成下面这样

```js
export default let i = 100
//或者
export default  i = 100
```

因为默认导出只能有一个，变量命名没什么必要。

还要注意以下写法的不同点，假定导出模块是如下的：

```js
let o = {
  age: 18,
}
exoport default o
```

导入模块要像下面这样使用

```js
import x from './test.js'
console.log(x.age)
```

如果导出模块是下面这样导出的

```js
exoport default {o}
```

那么导入模块要像下面这样使用

```js
import x from './test.js'
console.log(x.o.age)
```



### 匿名对象

导出的时候支持匿名。可以匿名导出变量、函数、对象等

```js
export default {}
```



```js
export default 900
```



```js
export default function(){}
```

### 混合导出

混合导出指的是默认导出与其它导出一起导出，比如下面

```js
export let i = 100
let j = 200
let k = 300
export {j as default,k}
```

导入时可以利用default引用默认导出，比如下面这样import

```js
import {default as n,k,i} from './a.js'
```

### 导入内容的再导出

导入其它模块的成员，重命名之后再导出

```js
export {i as n1,k} from './a.js'
```

也可以直接把导入模块的所有成员再次重新导出

```js
export * from './a.js'
```

# 反射与代理

Proxy是ES6新增的元编程内容，使用Proxy可以对被代理的对象进行拦截，当被代理的对象被访问时可以进行统一的处理

在以下简单的例子中，当对象中不存在属性名时，默认返回值为 `37`。下面的代码以此展示了 [`get`](https://developer.mozilla.org/zh-CN/docs/Web/JavaScript/Reference/Global_Objects/Proxy/handler/get) handler 的使用场景。

```js
const handler = {
    get: function(obj, prop) {
        return prop in obj ? obj[prop] : 37;
    }
};

const p = new Proxy({}, handler);
p.a = 1;
p.b = undefined;

console.log(p.a, p.b);      // 1, undefined
console.log('c' in p, p.c); // false, 37
```



```js
//被代理对象
let shape = {width:100}
let proxy = new Proxy(shape,{
    get:function(target,key,receiver){
        return 100
        // return Reflect.get(target,key,receiver)*1.1
    },
    set:function(target,key,value,receiver){
        console.log('给属性设置值')
        //return Reflect.set(target,key,value*1.1,receiver)
    }
})
```

## 反射

**Reflect** 是一个内置的对象，它提供拦截 JavaScript 操作的方法。这些方法与[proxy handlers](https://wiki.developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Proxy/handler)的方法相同。`Reflect`不是一个函数对象，因此它是不可构造的。

与大多数全局对象不同，`Reflect`并非一个构造函数，所以不能通过[new运算符](https://developer.mozilla.org/zh-CN/docs/Web/JavaScript/Reference/Operators/new)对其进行调用，或者将`Reflect`对象作为一个函数来调用。`Reflect`的所有属性和方法都是静态的（就像[`Math`](https://developer.mozilla.org/zh-CN/docs/Web/JavaScript/Reference/Global_Objects/Math)对象）。

```js
//检测一个对象是否存在特定属性
const duck = {
  name: 'Maurice',
  color: 'white',
  greeting: function() {
    console.log(`Quaaaack! My name is ${this.name}`);
  }
}

Reflect.has(duck, 'color');
// true
Reflect.has(duck, 'haircut');
// false

//返回这个对象自身的属性
Reflect.ownKeys(duck);
// [ "name", "color", "greeting" ]

//为这个对象添加一个新的属性
Reflect.set(duck, 'eyes', 'black');
// returns "true" if successful
// "duck" now contains the property "eyes: 'black'"
```



# 异步编程

在另外的文档中。

# 附录

## 逗号运算符

是优先级最低的运算符，运算时是从左到右，这个运算符自己不用用，框架代码中有用

```js
var a = b=2,c=3,d=4  //a=b=2,c=3,d=4
var a = (b=2,c=3,d=4); // a=d=4 b=2,c=3

function f(m,n){
    return m++,n++,m+n
}
var  result  = f(100,200) // result = 302
```



## 严格模式

默认情况下是非严格模式的，下面的代码在严格模式下会报错

```js
'use strict'
var a = 100
 delete a
console.log(a)

```

启用严格模式的方法有两种：

- 直接在script标签下写上`use strict`,这样就是整个script都处于严格模式下，只能放在第一行
- 在函数里面的第一行写上`use strict`，就表示本函数处于严格模式下

## json处理

把js对象变成一个json格式的字符串：JSON.stringify()，反之就是用JSON.parse

## 异常处理

```js
//2.全局处理错误
window.addEventListener('error', function (e) {
    console.log('出错了')
})

//调用一个不存在的方法
window.do()

// 1. 利用try catch处理错误
// try {
//   window.do()
// } catch (e) {
//   console.log('catch：' + e)
// }
```



# 参考资料

https://developer.mozilla.org/zh-CN/docs/Web/JavaScript

https://developer.mozilla.org/zh-CN/docs/Web/JavaScript/Reference

https://www.cnblogs.com/canfoo/p/6891868.html（vue的简单实现，有3次迭代）

https://www.cnblogs.com/he-wei/p/13649675.html（vue的简单实现2）
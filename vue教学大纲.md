# Vue概述

Vue (读音 /vjuː/，类似于 **view**) 是一套用于构建用户界面的**渐进式框架**。与其它大型框架不同的是，Vue 被设计为可以自底向上逐层应用。Vue 的核心库只关注视图层，不仅易于上手，还便于与第三方库或既有项目整合。另一方面，当与[现代化的工具链](https://cn.vuejs.org/v2/guide/single-file-components.html)以及各种[支持类库](https://github.com/vuejs/awesome-vue#libraries--plugins)结合使用时，Vue 也完全能够为复杂的单页应用提供驱动。其创始人是尤雨溪，中文官网地址为：https://cn.vuejs.org/

## 工具与js库的下载安装

建议安装以下工具

- vscode
  - liveserver
  - vue插件，提供语法高亮与code snippets
- vue devtools浏览器插件

### vue devtools安装下载

能访问到chrome浏览器的插件市场，直接搜索vue的开发工具插件即可安装，如果不能就搜索下载此插件安装文件，在chrome的扩展管理里进行安装

### vue库的下载

https://cn.vuejs.org/v2/guide/installation.html中有详细的说明，本文使用的vue版本是2.6.11

## Hello World

```html
<!-- 开发环境版本，包含了有帮助的命令行警告 -->
<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>

<div id="app">
  {{ message }}
</div>
<script>
    var app = new Vue({
        el: '#app',
        data: {
            message: 'Hello Vue!'
        }
    })
</script>
```

### el的值

 el是用来设置Vue实例挂载（管理）的元素，Vue会管理el选项命中的元素及其内部的后代元素，可以使用其他的选择器,但是建议使用ID选择器，可以使用其他的双标签,不能使用HTML和BODY

### data数据属性

Vue 实例观察的数据对象。Vue 实例代理了对其 data 对象 property 的访问。它的值有变化会影响挂载元素的渲染。

演示一下先插值读取属性值，后添加的属性值的情况

> 可以通过new Vue返回的实例的$data来访问这个数据属性

### 插值表达式

数据绑定最常见的形式就是使用“Mustache”语法 (双大括号) 的文本插值：

```
<span>Message: {{ msg }}</span>
```

Mustache 标签将会被替代为对应数据对象上 `msg` property 的值。无论何时，绑定的数据对象上 `msg` property 发生了改变，插值处的内容都会更新。

通过使用 [v-once 指令](https://cn.vuejs.org/v2/api/#v-once)，你也能执行一次性地插值，当数据改变时，插值处的内容不会更新。但请留心这会影响到该节点上的其它数据绑定：

```html
<span v-once>这个将不会改变: {{ msg }}</span>
```

双大括号会将数据解释为普通文本，而非 HTML 代码。为了输出真正的 HTML，你需要使用 [`v-html` 指令](https://cn.vuejs.org/v2/api/#v-html)：

```html
<p>Using mustaches: {{ rawHtml }}</p>
```

迄今为止，在我们的模板中，我们一直都只绑定简单的 property 键值。但实际上，对于所有的数据绑定，Vue.js 都提供了完全的 JavaScript 表达式支持。

```html
{{ number + 1 }}

{{ ok ? 'YES' : 'NO' }}

{{ message.split('').reverse().join('') }}
```

## Vue特点

### 声明式渲染

Vue.js 的核心是一个允许采用简洁的模板语法来声明式地将数据渲染进 DOM 的系统

### 响应式

现在数据和 DOM 已经被建立了关联，所有东西都是**响应式的**。我们要怎么确认呢？打开你的浏览器的 JavaScript 控制台 (就在这个页面打开)，并修改 `app.message` 的值，你将看到上例相应地更新。

### 渐进式

**VUE不强求你一次性接受并使用它的全部功能特性**。最开始只用vue的核心部分，比如视图渲染，之后可选的加上vue router，vuex等

# vue指令

指令 (Directives) 是带有 `v-` 前缀的特殊 attribute。指令 attribute 的值预期是**单个 JavaScript 表达式** (`v-for` 是例外情况，稍后我们再讨论)。指令的职责是，当表达式的值改变时，将其产生的连带影响，响应式地作用于 DOM。

## v-text

```html
<div id="app">
    <h2 v-text="message"></h2>
    <h2>深圳
        {{ message }}</h2>
</div>
```

v-text指令的作用是:

- 设置标签的内容(textContent) 
-  默认写法会替换全部内容,使用插值表达式{}可以替换指定内容
-  v-text  内部支持写表达式

## v-html

更新元素的 `innerHTML`。

> **注意：内容按普通 HTML 插入 - 不会作为 Vue 模板进行编译**

```html
<div id="app">
    <p v-html="content"/>
</div>
<script>
    var app = new Vue({
        el: '#app',
        data: {
            content: '<h1>Hello Vue!</h1>'
        }
    })
</script>
```

## v-on

绑定事件监听器

```html
<div id="app">
    <input type="button" value="事件绑定" von:click=“doIt"/>		<input type="button" value="事件绑定" von:monseenter=“doIt"/>
    <input type="button" value="事件绑定" von:dblclick=“doIt"/>		<input type="button" value="事件绑定" @dblclick=“doIt"/>
</div>
<script>
    var app = new Vue({
        el:"#app", methods:{
            doIt:function(){
                // 逻辑
            }
        }
    })
</script>
```

v-on指令的作用是:

- 为元素绑定事件 
-  事件名不需要写on v-on 
-  指令可以简写为@
-  绑定的方法定义在methods属性中 
-  方法内部通过this关键字可以访问定义在data中数据

### 案例：数字步进器

```html
 <div id="app">
      <input type="button" value="-" v-on:click="counter--" />
      <span>{{counter}}</span>
      <input type="button" value="+" v-on:click="counter++" />
    </div>

    <script src="../lib/vue.js"></script>

    <script>
      let vm = new Vue({
        el: '#app',
        data: {
          counter: 0,
        },
      })
</script>
```

### 传递参数

```html
 <div id="app">
      <input type="button" value="事件-传递参数" @click="handle(100,'abc')" />
      <input type="button" value="事件-传递参数2" @click="handle2(param)" />
      <input type="button" value="事件-传递参数3" @click="handle2(param*3)" />
      <!-- vue改造了事件处理的功能，比如说事件处理函数的this被vue改了 -->
      <input type="button" value="事件-传递参数4" @click="handle3($event)" />
      <input
        type="button"
        value="事件-传递参数5"
        @click="handle4(param,$event)"
      />
    </div>

    <script src="../lib/vue.js"></script>

    <script>
      let vm = new Vue({
        el: '#app',
        data: {
          counter: 0,
          param: 200,
        },
        methods: {
          handle: function (num, str) {
            alert(num)
            alert(str)
          },
          handle2: function (p) {
            alert(p)
          },
          handle3: function (e) {
            // e.stopPropagation()
            // e.preventDefault()
            console.log(e.target.value)
            console.log(e)
          },
          handle4: function (p, e) {
            console.log(p, e)
          },
        },
      })
    </script>
```



### 事件修饰符

- `.stop`
- `.prevent`
- `.capture`
- `.self`
- `.once`
- `.passive`

```html
 <div id="app">
      <a href="http://www.baidu.com" target="_blank" @click="handle($event)"
        >百度</a
      >

      <a href="http://www.baidu.com" target="_blank" @click.prevent="handle2()"
        >百度2</a
      >

      <input type="text" @keyup.enter="process" />
      <input type="text" @keyup.13="process" />
    </div>

    <script src="../lib/vue.js"></script>

    <script>
      let vm = new Vue({
        el: '#app',
        data: {},
        methods: {
          handle: function (e) {
            e.preventDefault()

            alert('dan ji l')
          },
          handle2: function () {
            alert('dan ji 2')
          },
          process: function () {
            alert('按键事件')
          },
        },
      })
    </script>
```





```html
<!-- 阻止单击事件继续传播 -->
<a v-on:click.stop="doThis"></a>

<!-- 提交事件不再重载页面 -->
<form v-on:submit.prevent="onSubmit"></form>

<!-- 修饰符可以串联 -->
<a v-on:click.stop.prevent="doThat"></a>

<!-- 只有修饰符 -->
<form v-on:submit.prevent></form>

<!-- 添加事件监听器时使用事件捕获模式 -->
<!-- 即内部元素触发的事件先在此处理，然后才交由内部元素进行处理 -->
<div v-on:click.capture="doThis">...</div>

<!-- 只当在 event.target 是当前元素自身时触发处理函数 -->
<!-- 即事件不是从内部元素触发的 -->
<div v-on:click.self="doThat">...</div>
```



### 按键修饰符

在监听键盘事件时，我们经常需要检查详细的按键。Vue 允许为 `v-on` 在监听键盘事件时添加按键修饰符：

```html
<!-- 只有在 `key` 是 `Enter` 时调用 `vm.submit()` -->
<input v-on:keyup.enter="submit">
```

你可以直接将 [`KeyboardEvent.key`](https://developer.mozilla.org/en-US/docs/Web/API/KeyboardEvent/key/Key_Values) 暴露的任意有效按键名转换为 kebab-case 来作为修饰符。

```html
<input v-on:keyup.page-down="onPageDown">
```

在上述示例中，处理函数只会在 `$event.key` 等于 `PageDown` 时被调用。

***按键码***

`keyCode` 的事件用法[已经被废弃了](https://developer.mozilla.org/en-US/docs/Web/API/KeyboardEvent/keyCode)并可能不会被最新的浏览器支持。

使用 `keyCode` attribute 也是允许的：

```
<input v-on:keyup.13="submit">
```

为了在必要的情况下支持旧浏览器，Vue 提供了绝大多数常用的按键码的别名：

- `.enter`
- `.tab`
- `.delete` (捕获“删除”和“退格”键)
- `.esc`
- `.space`
- `.up`
- `.down`
- `.left`
- `.right`

有一些按键 (`.esc` 以及所有的方向键) 在 IE9 中有不同的 `key` 值, 如果你想支持 IE9，这些内置的别名应该是首选。

你还可以通过全局 `config.keyCodes` 对象[自定义按键修饰符别名](https://cn.vuejs.org/v2/api/#keyCodes)：

```js
// 可以使用 `v-on:keyup.f1`
Vue.config.keyCodes.f1 = 112
```

简单的todo：

```html
 <div id="app">
      <input type="text" @keyup.enter="add" v-model="task" />
      <ul>
        <li v-for="item in items">{{item}}</li>
      </ul>
    </div>

    <script src="../lib/vue.js"></script>

    <script>
      let vm = new Vue({
        el: '#app',
        data: {
          items: [],
          task: '',
        },
        methods: {
          add: function () {
            this.items.push(this.task)
          },
        },
      })
    </script>
```



### 系统修饰键

可以用如下修饰符来实现仅在按下相应按键时才触发鼠标或键盘事件的监听器。

- `.ctrl`
- `.alt`
- `.shift`
- `.meta`

```html
<!-- Alt + C -->
<input v-on:keyup.alt.67="clear">

<!-- Ctrl + Click -->
<div v-on:click.ctrl="doSomething">Do something</div>
```

***.exact修饰符***

`.exact` 修饰符允许你控制由精确的系统修饰符组合触发的事件。

```html
<!-- 即使 Alt 或 Shift 被一同按下时也会触发 -->
<button v-on:click.ctrl="onClick">A</button>

<!-- 有且只有 Ctrl 被按下的时候才触发 -->
<button v-on:click.ctrl.exact="onCtrlClick">A</button>

<!-- 没有任何系统修饰符被按下的时候才触发 -->
<button v-on:click.exact="onClick">A</button>
```

***鼠标修饰符***

- `.left`
- `.right`
- `.middle`

这些修饰符会限制处理函数仅响应特定的鼠标按钮。



## v-show

> 根据表达式之真假值，切换元素的 `display` CSS property。

v-show指令的作用是:

- 根据真假切换元素的显示状态
- 原理是修改元素的display,实现显示隐藏 v-show 
-  指令后面的内容,最终都会解析为布尔值 
-  值为true元素显示,值为false元素隐藏 
-  数据改变之后,对应元素的显示状态会同步更新

```html
<div id="app">
    <img src="地址" v-show="true" />
    <img src="地址" vshow=“isShow" />
    <img src="地址" vshow=“age>=18" />
</div>

<script>
    var app = new Vue({
        el:"#app",
        data:{
            isShow:false,
            age:16
        }
    })
</script>
```

## v-if

> 根据表达值的真假,切换元素的显示和隐藏

v-if指令的作用是:

- 根据表达式的真假切换元素的显示状态 
-  本质是通过操纵dom元素来切换显示状态 
-  表达式的值为true,元素存在于dom树中,为false,从dom树中移除 v-if 
-  频繁的切换v-show,反之使用v-if（因为频繁操作DOM耗性能）,前者的切换消耗小

使用方法与v-show类似

### v-else

前一兄弟元素必须有 `v-if` 或 `v-else-if`。为 `v-if` 或者 `v-else-if` 添加“else 块”。

```html
<div v-if="Math.random() > 0.5">
  Now you see me
</div>
<div v-else>
  Now you don't
</div>
```

### v-else-if

前一兄弟元素必须有 `v-if` 或 `v-else-if`。表示 `v-if` 的“else if 块”。可以链式调用。

```html
<div v-if="type === 'A'">
  A
</div>
<div v-else-if="type === 'B'">
  B
</div>
<div v-else-if="type === 'C'">
  C
</div>
<div v-else>
  Not A/B/C
</div>
```

## v-bind

设置元素的属性，比如:src,title,class

v-bind指令的作用是:

- 为元素绑定属性 
-  完整写法是 `v-bind:属性名 `
-  简写的话可以直接省略v-bind,只保留` :属性名 `
-  需要动态的增删class建议使用对象的方式

```html
<div id="app">
    <img v-bind:src= "imgSrc" >
    <img :title="imgtitle+’!!!!’">
    <img :class="isActive?'active':‘’”>
    <img :class="{active:isActive}">
                                   
</div>
```



```js
var app = new Vue({
    el:"#app",
    data:{
        imgSrc:"图片地址",
        imgTitle:"黑马程序员",
        isActive:false
    }
})
```



### class属性的绑定

> https://cn.vuejs.org/v2/guide/class-and-style.html
>
> https://cn.vuejs.org/v2/api/#v-bind

操作元素的 class 列表和内联样式是数据绑定的一个常见需求。因为它们都是 attribute，所以我们可以用 `v-bind` 处理它们：只需要通过表达式计算出字符串结果即可。不过，字符串拼接麻烦且易错。因此，在将 `v-bind` 用于 `class` 和 `style` 时，Vue.js 做了专门的增强。表达式结果的类型除了字符串之外，还可以是对象或数组。



***绑定到普通的字符串数据***

```html
<div id="app">
    <p :class="str">asdfasdf</p>
</div>
new Vue({
el: '#app',
data: {
str: 'abc',
},
})
```

最终p标记如果data中有str属性，那么p的class值只有abc这一个，如果没有str属性，那么p的class值就是空的，什么都没有

****

***静态与动态的结合***

```html
 <p class="init" :class="str">asdfasdf</p>
```

最终p的class固定是有init的，如果有str属性，那么就多一个class值

***对象语法***

```html
<p :class="{active:isactive}">333</p>
data: {
str: 'abc',
isactive: true,
},
```

最终p的class值就是active，如果isactive=false，那么p的class就是空的

```html
<p :class="{active:isactive,c:isx}">444</p>
data: {
str: 'abc',
isactive: true,
isx: true,
},
```

最终p的class值就是active和c

绑定的数据对象不必内联定义在模板里：

```html
  <p :class="styleObject">555</p>
data: {
    styleObject: {
        active: true,
        c: true,
        d: false,
    },
},
```

最终p标记的class值为active与c

> 总结：对象这种写法，对象的属性名会作为class的值，这个属性名是否作为值是由其属性值决定



****

***数组语法***

```html
  <p :class="[a,b]">666</p>
```



```js
data: {
    a: 'mmm',
    b: 'xxx',
},
```

最终的结果是p有2个样式类值，分别是mmm和xxx，你可以尝试一下把属性a的值改为true，看看效果，发现不报错，但最终的class值中既没有a也没有mmm

> 如果没有a，b2个属性会在控制台输出错误。说找不到a,b属性或方法

有时数组中的某个样式属性是在某些条件下才应该有，那么就应该像下面这样写

```html
<p :class="[isactive==true?c:'',d]">777</p>
```

对象的data是：

```js
data: {
    isactive: false,
    c: 'iii',
    d: 'uuu',
},
```

最终的class值是iii与uuu，如果isactive是false，那么就只有uuu

你也可以像下面这样写：

```html
 <p :class="[{e:isactive},f]">888</p>
```

data值是这样：

```js
data: {
          isactive: true,
          e: 'eee',
          f: 'fff',
        },
```

最终的class的值是e和fff,***注意不是eee和fff***，如果isactive是false，那么class的值就只有fff

### style属性绑定

`v-bind:style` 的对象语法十分直观——看着非常像 CSS，但其实是一个 JavaScript 对象。CSS property 名可以用驼峰式 (camelCase) 或短横线分隔 (kebab-case，记得用引号括起来) 来命名

***对象写法***

```html
<p :style="{fontSize:a}">111</p>
```

对应的data

```js
data: {
    a: '18px',
},
```

最终的结果是p的style中的`font-size:18px`

如果像上面那样编写，样式多的话就会导致：style的内容很多，不好查看，建议用下面的方式：直接写上样式对象

```html
<p :style="abc">22</p>
```

对应的data：

```js
data: {
    abc: { //上面的abc对应这里
        fontSize: '18px',
        color: 'red',
    },
},
```

最终的结果是`font-size:18px color:red`

***数组语法***

`v-bind:style` 的数组语法可以将多个样式对象应用到同一个元素上：

```html
  <p :style="[x,y]">33</p>
```

对应的data：

```js
data: {
    x: {
        fontSize: '18px',
    },
    y: {
       color: 'red',
       border: '1px solid green',
    },
}
```

最终的结果：`font-size: 18px; color: red; border: 1px solid green;`

```html
 <div id="app">
      <img :src="imgList[index]" />
      <a href="#" v-on:click="prev" v-show="index>0">
        <img src="../images/prev.png" />
      </a>
      <a href="#" @click="next" v-show="index<imgList.length-1"
        ><img src="../images/next.png"
      /></a>
    </div>
```



```js
 let vm = new Vue({
        el: '#app',
        data: {
          imgList: [
            '../images/100.jpg',
            '../images/200.jpg',
            '../images/300.jpg',
            '../images/400.jpg',
            '../images/500.jpg',
          ],
          index: 0,
        },
        methods: {
          prev: function () {
            this.index--
          },
          next: function () {
            this.index++
          },
        },
      })
```

### 案例：手风琴(`$refs`)

下面版本的手风琴是可以展开多个面板的，并且***演示了ref元素属性与vue的$refs实例属性***的用法，使用步骤如下：

- 在被Vue管理的元素内，给某个元素添加ref属性并赋值，比如叫xxx
- 然后就可以利用vue的实例属性`$refs`对象来获取被ref属性修饰的元素了：`this.$refs.xxx`,得到的一个dom对象

```html
<div id="app">
      <div class="accordion">
        <h3 @click="handle1">选项卡</h3>
        <div :class="{hide:xuanxiangyi}">111111</div>
        <h3 @click="handle2">选项卡2</h3>
        <div ref="xxx">2222</div>
        <h3 @click="handle3">选项卡3</h3>
        <div :class="{hide:xuanxiangyi3}">333</div>
      </div>
    </div>
    <script src="../lib/vue.js"></script>

    <script>
      let vm = new Vue({
        el: '#app',
        data: {
          xuanxiangyi: false,

          xuanxiangyi3: false,
        },
        methods: {
          handle1: function () {
            this.xuanxiangyi = !this.xuanxiangyi
          },
          handle2: function () {
            let div = this.$refs.xxx
            div.classList.toggle('hide')
          },
          handle3: function () {
            this.xuanxiangyi3 = !this.xuanxiangyi3
          },
        },
      })
    </script>
```



这个案例演示了事件参数与class的处理，与https://c.runoob.com/codedemo/3157类似

```html
<div id="app">
      <button class="accordion" @click="handle(1)" :class="{active:active==1}">
        选项 1
      </button>
      <div class="panel" :class="{hide:active !== 1}">
        <p>
          1 Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do
          eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad
          minim veniam, quis nostrud exercitation ullamco laboris nisi ut
          aliquip ex ea commodo consequat.
        </p>
      </div>

      <button class="accordion" @click="handle(2)" :class="{active:active==2}">
        选项 2
      </button>
      <div class="panel" :class="{hide:active !== 2}">
        <p>
          2Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do
          eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad
          minim veniam, quis nostrud exercitation ullamco laboris nisi ut
          aliquip ex ea commodo consequat.
        </p>
      </div>

      <button class="accordion" @click="handle(3)" :class="{active:active==3}">
        选项 3
      </button>
      <div class="panel" :class="{hide:active !== 3}">
        <p>3Lorem ipsum dolor sit amet, consectetur adipisic</p>
      </div>
    </div>
    <script src="../lib/vue.js"></script>

    <script>
      let vm = new Vue({
        el: '#app',
        data: {
          active: 0,
        },
        methods: {
          handle: function (index) {
            console.log('----', index)
            this.active = index
          },
        },
      })
    </script>
```



## v-for

基于源数据多次渲染元素或模板块。此指令之值，必须使用特定语法 `alias in expression`，为当前遍历的元素提供别名：

```html
 <body>
    <div id="app">
      <p v-for="item in items">{{item}}</p>
      <p v-for="(item,index) in items">{{index}} ----- {{item}}</p>

      <p v-for="item in items2">名字：{{item.name}} 年龄:{{item.age}}</p>
      <p v-for="(item,index) in items2">
        {{index}}----名字：{{item.name}} 年龄:{{item.age}}
      </p>

      <p v-for="(value,name,index) in myobj">
        {{index}}----属性名:{{name}} 属性值:{{value}}
      </p>
    </div>

    <script src="../lib/vue.js"></script>

    <script>
      new Vue({
        el: '#app',
        data: {
          items: ['a', 'b', 'c'],
          items2: [
            { name: 'abc', age: 18 },
            { name: 'def', age: 19 },
            { name: 'xxx', age: 15 },
            { name: 'yyy', age: 13 },
          ],
          myobj: {
            age: 18,
            gender: true,
          },
        },
      })
    </script>
```

### key的问题

***总原则：用v-for指令的时候，一定一定要加key，其值必须是唯一的，最好最好别用index。***

> 在vue的api的key 属性一节中有下面的说明
>
> `key` 的特殊 attribute 主要用在 Vue 的虚拟 DOM 算法，在新旧 nodes 对比时辨识 VNodes。如果不使用 key，Vue 会使用一种最大限度减少动态元素并且尽可能的尝试就地修改/复用相同类型元素的算法。而使用 key 时，它会基于 key 的变化重新排列元素顺序，并且会移除 key 不存在的元素。



> https://www.cnblogs.com/yangpeixian/p/11707069.html
>
> https://www.zhihu.com/question/61064119/answer/766607894
>
> https://www.jianshu.com/p/4bd5e745ce95

下面的代码在不加key的时候，如果预先选择了一个checkbox，比如第三个，那么添加数据时，会改变选择的项，加了key后就没有这个问题了。

```html
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta http-equiv="X-UA-Compatible" content="ie=edge" />
    <title>Document</title>
  </head>

  <body>
    <div id="app">
      <div>
        <label
          >Id:
          <input type="text" v-model="id" />
        </label>

        <label
          >Name:
          <input type="text" v-model="name" />
        </label>

        <input type="button" value="添加" @click="add" />
      </div>

      <p v-for="item in list" v-bind:key="item.id">
        <input type="checkbox" />{{ item.id }} --- {{ item.name }}
      </p>
    </div>
    <script src="../lib/vue.js"></script>
    <script>
      var vm = new Vue({
        el: '#app',
        data: {
          id: '',
          name: '',
          list: [
            {
              id: 1,
              name: '勒布朗',
            },
            {
              id: 2,
              name: '杜兰特',
            },
            {
              id: 3,
              name: '库里',
            },
            {
              id: 4,
              name: '罗斯',
            },
            {
              id: 5,
              name: '乔治',
            },
          ],
        },
        methods: {
          add() {
            this.list.unshift({ id: this.id, name: this.name })
          },
        },
      })
    </script>
  </body>
</html>

```



> 从 2.6 起，`v-for` 也可以在实现了[可迭代协议](https://developer.mozilla.org/zh-CN/docs/Web/JavaScript/Reference/Iteration_protocols#可迭代协议)的值上使用，包括原生的 `Map` 和 `Set`。不过应该注意的是 Vue 2.x 目前并不支持可响应的 `Map` 和 `Set` 值，所以无法自动探测变更。

### 练习：表格与分页

```html
<div id="app">
    <div>
        <a
           v-for="item in pageinfo.nums"
           :class="{currentpage:item === pageinfo.currentpage}"
           >{{item}}</a
            >
    </div>

    <table>
        <thead>
            <tr>
                <th>编号</th>
                <th>名字</th>
                <th>年龄</th>
            </tr>
        </thead>
        <tbody>
            <tr v-for="(item,index) in items">
                <td>{{index+1}}</td>
                <td>{{item.name}}</td>
                <td>{{item.age}}</td>
            </tr>
        </tbody>
    </table>
</div>

<script src="../lib/vue.js"></script>

<script>
    new Vue({
        el: '#app',
        data: {
            pageinfo: {
                nums: [10, 11, 12, 13, 14, 15],
                currentpage: 12,
            },
            items: [
                { name: 'zhangsan', age: 18 },
                { name: 'lisi', age: 28 },
                { name: 'wangmazi', age: 16 },
            ],
        },
    })
</script>
```



## v-model

在表单控件或者组件上创建双向绑定

获取和设置表单元素的值,https://cn.vuejs.org/v2/guide/forms.html

### 案例：todolist

> https://cn.vuejs.org/v2/examples/todomvc.html 

下面是一个简化版本的todolist

```html
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Document</title>
    <style>
      html,
      body {
        margin: 0;
        padding: 0;
      }
      body {
        background: #fff;
      }
      button {
        margin: 0;
        padding: 0;
        border: 0;
        background: none;
        font-size: 100%;
        vertical-align: baseline;
        font-family: inherit;
        font-weight: inherit;
        color: inherit;
        -webkit-appearance: none;
        appearance: none;
        -webkit-font-smoothing: antialiased;
        -moz-osx-font-smoothing: grayscale;
      }

      body {
        font: 14px 'Helvetica Neue', Helvetica, Arial, sans-serif;
        line-height: 1.4em;
        background: #f5f5f5;
        color: #4d4d4d;
        min-width: 230px;
        max-width: 550px;
        margin: 0 auto;
        -webkit-font-smoothing: antialiased;
        -moz-osx-font-smoothing: grayscale;
        font-weight: 300;
      }

      :focus {
        outline: 0;
      }

      .hidden {
        display: none;
      }

      #todoapp {
        background: #fff;
        margin: 180px 0 40px 0;
        position: relative;
        box-shadow: 0 2px 4px 0 rgba(0, 0, 0, 0.2),
          0 25px 50px 0 rgba(0, 0, 0, 0.1);
      }

      #todoapp input::-webkit-input-placeholder {
        font-style: italic;
        font-weight: 300;
        color: #e6e6e6;
      }

      #todoapp input::-moz-placeholder {
        font-style: italic;
        font-weight: 300;
        color: #e6e6e6;
      }

      #todoapp input::input-placeholder {
        font-style: italic;
        font-weight: 300;
        color: gray;
      }

      #todoapp h1 {
        position: absolute;
        top: -160px;
        width: 100%;
        font-size: 60px;
        font-weight: 100;
        text-align: center;
        color: rgba(175, 47, 47, 0.8);
        -webkit-text-rendering: optimizeLegibility;
        -moz-text-rendering: optimizeLegibility;
        text-rendering: optimizeLegibility;
      }

      .new-todo,
      .edit {
        position: relative;
        margin: 0;
        width: 100%;
        font-size: 24px;
        font-family: inherit;
        font-weight: inherit;
        line-height: 1.4em;
        border: 0;
        color: inherit;
        padding: 6px;
        border: 1px solid #999;
        box-shadow: inset 0 -1px 5px 0 rgba(0, 0, 0, 0.2);
        box-sizing: border-box;
        -webkit-font-smoothing: antialiased;
        -moz-osx-font-smoothing: grayscale;
      }

      .new-todo {
        padding: 16px;
        border: none;
        background: rgba(0, 0, 0, 0.003);
        box-shadow: inset 0 -2px 1px rgba(0, 0, 0, 0.03);
      }

      .main {
        position: relative;
        z-index: 2;
        border-top: 1px solid #e6e6e6;
      }

      .toggle-all {
        width: 1px;
        height: 1px;
        border: none; /* Mobile Safari */
        opacity: 0;
        position: absolute;
        right: 100%;
        bottom: 100%;
      }

      .toggle-all + label {
        width: 60px;
        height: 34px;
        font-size: 0;
        position: absolute;
        top: -52px;
        left: -13px;
        -webkit-transform: rotate(90deg);
        transform: rotate(90deg);
      }

      .toggle-all + label:before {
        content: '❯';
        font-size: 22px;
        color: #e6e6e6;
        padding: 10px 27px 10px 27px;
      }

      .toggle-all:checked + label:before {
        color: #737373;
      }

      .todo-list {
        margin: 0;
        padding: 0;
        list-style: none;
        max-height: 420px;
        overflow: auto;
      }

      .todo-list li {
        position: relative;
        font-size: 24px;
        border-bottom: 1px solid #ededed;
        height: 60px;
        box-sizing: border-box;
      }

      .todo-list li:last-child {
        border-bottom: none;
      }

      .todo-list .view .index {
        position: absolute;
        color: gray;
        left: 10px;
        top: 20px;
        font-size: 16px;
      }

      .todo-list li .toggle {
        text-align: center;
        width: 40px;
        /* auto, since non-WebKit browsers doesn't support input styling */
        height: auto;
        position: absolute;
        top: 0;
        bottom: 0;
        margin: auto 0;
        border: none; /* Mobile Safari */
        -webkit-appearance: none;
        appearance: none;
      }

      .todo-list li .toggle {
        opacity: 0;
      }

      .todo-list li .toggle + label {
        /*
		Firefox requires `#` to be escaped - https://bugzilla.mozilla.org/show_bug.cgi?id=922433
		IE and Edge requires *everything* to be escaped to render, so we do that instead of just the `#` - https://developer.microsoft.com/en-us/microsoft-edge/platform/issues/7157459/
	*/
        background-image: url('data:image/svg+xml;utf8,%3Csvg%20xmlns%3D%22http%3A//www.w3.org/2000/svg%22%20width%3D%2240%22%20height%3D%2240%22%20viewBox%3D%22-10%20-18%20100%20135%22%3E%3Ccircle%20cx%3D%2250%22%20cy%3D%2250%22%20r%3D%2250%22%20fill%3D%22none%22%20stroke%3D%22%23ededed%22%20stroke-width%3D%223%22/%3E%3C/svg%3E');
        background-repeat: no-repeat;
        background-position: center left;
      }

      .todo-list li .toggle:checked + label {
        background-image: url('data:image/svg+xml;utf8,%3Csvg%20xmlns%3D%22http%3A//www.w3.org/2000/svg%22%20width%3D%2240%22%20height%3D%2240%22%20viewBox%3D%22-10%20-18%20100%20135%22%3E%3Ccircle%20cx%3D%2250%22%20cy%3D%2250%22%20r%3D%2250%22%20fill%3D%22none%22%20stroke%3D%22%23bddad5%22%20stroke-width%3D%223%22/%3E%3Cpath%20fill%3D%22%235dc2af%22%20d%3D%22M72%2025L42%2071%2027%2056l-4%204%2020%2020%2034-52z%22/%3E%3C/svg%3E');
      }

      .todo-list li label {
        word-break: break-all;
        padding: 15px 15px 15px 60px;
        display: block;
        line-height: 1.2;
        transition: color 0.4s;
      }

      .todo-list li.completed label {
        color: #d9d9d9;
        text-decoration: line-through;
      }

      .todo-list li .destroy {
        display: none;
        position: absolute;
        top: 0;
        right: 10px;
        bottom: 0;
        width: 40px;
        height: 40px;
        margin: auto 0;
        font-size: 30px;
        color: #cc9a9a;
        margin-bottom: 11px;
        transition: color 0.2s ease-out;
      }

      .todo-list li .destroy:hover {
        color: #af5b5e;
      }

      .todo-list li .destroy:after {
        content: '×';
      }

      .todo-list li:hover .destroy {
        display: block;
      }

      .todo-list li .edit {
        display: none;
      }

      .todo-list li.editing:last-child {
        margin-bottom: -1px;
      }

      .footer {
        color: #777;
        padding: 10px 15px;
        height: 20px;
        text-align: center;
        border-top: 1px solid #e6e6e6;
      }

      .footer:before {
        content: '';
        position: absolute;
        right: 0;
        bottom: 0;
        left: 0;
        height: 50px;
        overflow: hidden;
        box-shadow: 0 1px 1px rgba(0, 0, 0, 0.2), 0 8px 0 -3px #f6f6f6,
          0 9px 1px -3px rgba(0, 0, 0, 0.2), 0 16px 0 -6px #f6f6f6,
          0 17px 2px -6px rgba(0, 0, 0, 0.2);
      }

      .todo-count {
        float: left;
        text-align: left;
      }

      .todo-count strong {
        font-weight: 300;
      }

      .filters {
        margin: 0;
        padding: 0;
        list-style: none;
        position: absolute;
        right: 0;
        left: 0;
      }

      .filters li {
        display: inline;
      }

      .filters li a {
        color: inherit;
        margin: 3px;
        padding: 3px 7px;
        text-decoration: none;
        border: 1px solid transparent;
        border-radius: 3px;
      }

      .filters li a:hover {
        border-color: rgba(175, 47, 47, 0.1);
      }

      .filters li a.selected {
        border-color: rgba(175, 47, 47, 0.2);
      }

      .clear-completed,
      html .clear-completed:active {
        float: right;
        position: relative;
        line-height: 20px;
        text-decoration: none;
        cursor: pointer;
      }

      .clear-completed:hover {
        text-decoration: underline;
      }

      .info {
        margin: 50px auto 0;
        color: #bfbfbf;
        font-size: 15px;
        text-shadow: 0 1px 0 rgba(255, 255, 255, 0.5);
        text-align: center;
      }

      .info p {
        line-height: 1;
      }

      .info a {
        color: inherit;
        text-decoration: none;
        font-weight: 400;
      }

      .info a:hover {
        text-decoration: underline;
      }

      /*
	Hack to remove background from Mobile Safari.
	Can't use it globally since it destroys checkboxes in Firefox
*/
      @media screen and (-webkit-min-device-pixel-ratio: 0) {
        .toggle-all,
        .todo-list li .toggle {
          background: none;
        }

        .todo-list li .toggle {
          height: 40px;
        }
      }

      @media (max-width: 430px) {
        .footer {
          height: 50px;
        }

        .filters {
          bottom: 10px;
        }
      }
    </style>
  </head>
  <body>
    <!-- 主体区域 -->
    <section id="todoapp">
      <!-- 输入框 -->
      <header class="header">
        <h1>todo-list</h1>
        <input
          v-model="inputValue"
          @keyup.enter="add"
          autofocus="autofocus"
          autocomplete="off"
          placeholder="请输入任务"
          class="new-todo"
        />
      </header>
      <!-- 列表区域 -->
      <section class="main">
        <ul class="todo-list">
          <li class="todo" v-for="(item,index) in list">
            <div class="view">
              <span class="index">{{ index+1 }}.</span>
              <label>{{ item }}</label>
              <button class="destroy" @click="remove(index)"></button>
            </div>
          </li>
        </ul>
      </section>
      <!-- 统计和清空 -->
      <footer class="footer" v-show="list.length!=0">
        <span class="todo-count" v-if="list.length!=0">
          <strong>{{ list.length }}</strong> items left
        </span>
        <button v-show="list.length!=0" class="clear-completed" @click="clear">
          Clear
        </button>
      </footer>
    </section>

    <script src="../lib/vue.js"></script>
    <script>
      var app = new Vue({
        el: '#todoapp',
        data: {
          list: ['aaa', 'bbb', 'ccc'],
          inputValue: 'aaaa',
        },
        methods: {
          add: function () {
            this.list.push(this.inputValue)
          },
          remove: function (index) {
            console.log('删除')
            console.log(index)
            this.list.splice(index, 1)
          },
          clear: function () {
            this.list = []
          },
        },
      })
    </script>
  </body>
</html>

```



### MVVM

MVVM（Model–View–Viewmodel）是一种软件架构模式。MVVM是马丁·福勒的PM（Presentation Model）设计模式的变体。 MVVM以相同的方式抽象出视图的状态和行为,但PM以不依赖于特定用户界面平台的方式抽象出视图（创建了视图模型）。MVVM和PM都来自MVC模式。

MVVM分为三个部分：分别是M（Model，模型层 ），V（View，视图层），VM（ViewModel，V与M连接的桥梁，也可以看作为控制器）
 1、 M：模型层，主要负责业务数据相关；
 2、 V：视图层，顾名思义，负责视图相关，细分下来就是html+css层；
 3、 VM：V与M沟通的桥梁，负责监听M或者V的修改，是实现MVVM双向绑定的要点；

MVVM支持双向绑定，意思就是当M层数据进行修改时，VM层会监测到变化，并且通知V层进行相应的修改，反之修改V层则会通知M层数据进行修改，以此也实现了视图与模型层的相互解耦；



![vue mvvm](http://cn.vuejs.org/images/mvvm.png?_=5619070)

查看这个文章即可：https://www.liaoxuefeng.com/wiki/1022910821149312/1108898947791072

## v-cloak指令

> https://www.jianshu.com/p/f56cde007210?utm_source=oschina-app

可以使用 v-cloak 指令设置样式，这些样式会在 Vue 实例编译结束时，从绑定的 HTML 元素上被移除。

当网络较慢，网页还在加载 Vue.js ，而导致 Vue 来不及渲染，这时页面就会显示出 Vue 源代码。我们可以使用 v-cloak 指令来解决这一屏幕闪动的问题。

```html
<div id="app" v-cloak>
    {{context}}
</div>
```



```css
[v-cloak]{
    display: none;
}
```

# 计算属性与监听属性

下面是一个简单的计算属性,计算属性一般是要返回值的。

```js
computed:{
    total:function(){
        return this.unitprice * this.qty
    }
}
```

使用方法就当成普通的数据属性使用即可，比如

```html
<span>总价：{{total}}</span>
```

> 虽然计算属性编写的时候像一个方法，但其实是个属性，所以使用的时候不需要像方法调用那样加括号:total()

计算属性也可以有独立的getter，setter，比如下面

```js
computed: {
  fullName: {
    // getter
    get: function () {
      return this.firstName + ' ' + this.lastName
    },
    // setter
    set: function (newValue) {
      var names = newValue.split(' ')
      this.firstName = names[0]
      this.lastName = names[names.length - 1]
    }
  }
}
```

## 计算属性与方法区别

不断改变name的值会导致视图重新渲染，然后getTotal方法就会不断得到调用，但计算属性total却不会。两者主要区别如下：

- 计算属性只能当属性用
- 计算属性可以有getter、setter
- 计算属性不能带参数，有缓存，效率高
- 方法可以直接调用，可带参数，没有缓存，每次调用都会执行，效率不如计算属性高

```html
 <div id="app">
      <input v-model="name"/>
      单价：<input v-model="price"/>
      数量：<input v-model="amount"/>
      总价：{{total}}
      总价：{{getTotal()}}
    </div>
    <script src="../js/vue/vue.min.js"></script>
    <script>
      var vm = new Vue({
        el: '#app',
        data: {
          name:"价格计算",
          price:198.5,  //单价
          amount:1000   //数量
        },
        methods:{
          getTotal(){  //获取总价方法
            console.log("方法getTotal被调用");
            return this.price*this.amount;
          }
        },
        computed: {  //计算属性
          total: function () {  //计算总价
            console.log("计算属性total被调用");
            return this.price*this.amount;  //单价乘以数量为总价
          }
        }
      })
    </script>
```

## 监听属性（侦听属性）

Vue 提供了一种更通用的方式来观察和响应 Vue 实例上的数据变动：**侦听属性**。当你有一些数据需要随着其它数据变动而变动时，你很容易滥用 `watch`——特别是如果你之前使用过 AngularJS。然而，通常更好的做法是使用计算属性而不是命令式的 `watch` 回调。细想一下这个例子：

```js
<div id="demo">{{ fullName }}</div>
var vm = new Vue({
  el: '#demo',
  data: {
    firstName: 'Foo',
    lastName: 'Bar',
    fullName: 'Foo Bar'
  },
  watch: {
    firstName: function (val) {
      this.fullName = val + ' ' + this.lastName
    },
    lastName: function (val) {
      this.fullName = this.firstName + ' ' + val
    }
  }
})
```

上面代码是命令式且重复的。将它与计算属性的版本进行比较：

```js
var vm = new Vue({
  el: '#demo',
  data: {
    firstName: 'Foo',
    lastName: 'Bar'
  },
  computed: {
    fullName: function () {
      return this.firstName + ' ' + this.lastName
    }
  }
})
```

好得多了，不是吗？

**侦听属性watch：**

- 不支持缓存，数据变，直接会触发相应的操作；
- watch支持异步；
- 监听的函数接收两个参数，第一个参数是最新的值；第二个参数是输入之前的值；
- 当一个属性发生变化时，需要执行对应的操作；一对多；
- 监听数据必须是data中声明过或者父组件传递过来的props中的数据，当数据变化时，触发其他操作，函数有两个参数，
  - immediate：组件加载立即触发回调函数执行，
  - deep: 深度监听，为了发现**对象内部值**的变化，复杂类型的数据时使用，例如数组中的对象内容的改变，注意监听数组的变动不需要这么做。注意：deep无法监听到数组的变动和对象的新增，参考vue数组变异,只有以响应式的方式触发才会被监听到。



# 过滤器

Vue.js 允许你自定义过滤器，可被用于一些常见的文本格式化。过滤器可以用在两个地方：**双花括号插值和 `v-bind` 表达式** (后者从 2.1.0+ 开始支持)。

## 过滤器的创建与注册

你可以在一个组件的选项中定义局部的过滤器：

```js
filters: {
  capitalize: function (value) {
    if (!value) return ''
    value = value.toString()
    return value.charAt(0).toUpperCase() + value.slice(1)
  }
}
```

或者在创建 Vue 实例之前定义并注册全局过滤器：

```js
Vue.filter('capitalize', function (value) {
  if (!value) return ''
  value = value.toString()
  return value.charAt(0).toUpperCase() + value.slice(1)
})

new Vue({
  // ...
})
```

当全局过滤器和局部过滤器重名时，会采用局部过滤器。

## 过滤器的使用

过滤器应该被添加在 JavaScript 表达式的尾部，由“管道”符号也就是`|`指示：

```
<!-- 在双花括号中 -->
{{ message | capitalize }}

<!-- 在 `v-bind` 中 -->
<div v-bind:id="rawId | formatId"></div>
```

## 过滤器参数

过滤器函数总接收表达式的值作为第一个参数。在上述例子中，`capitalize` 过滤器函数将会收到 `message` 的值作为第一个参数。

过滤器是 JavaScript 函数，因此可以接收参数：

```html
{{ message | filterA('arg1', arg2) }}
```

这里，`filterA` 被定义为接收三个参数的过滤器函数。其中 `message` 的值作为第一个参数，普通字符串 `'arg1'` 作为第二个参数，表达式 `arg2` 的值作为第三个参数。

## 过滤器链

过滤器可以串联：

```
{{ message | filterA | filterB }}
```

在这个例子中，`filterA` 被定义为接收单个参数的过滤器函数，表达式 `message` 的值将作为参数传入到函数中。然后继续调用同样被定义为接收单个参数的过滤器函数 `filterB`，将 `filterA` 的结果传递到 `filterB` 中。

## 练习：时间格式化过滤器

参考此文编写https://www.cnblogs.com/sexintercourse/p/6490921.html

```js
 Vue.filter('format', function (val, fmt) {
        var o = {
          'M+': val.getMonth() + 1, //月份
          'd+': val.getDate(), //日
          'h+': val.getHours(), //小时
          'm+': val.getMinutes(), //分
          's+': val.getSeconds(), //秒
          'q+': Math.floor((val.getMonth() + 3) / 3), //季度
          S: val.getMilliseconds(), //毫秒
        }
        if (/(y+)/.test(fmt))
          fmt = fmt.replace(
            RegExp.$1,
            (val.getFullYear() + '').substr(4 - RegExp.$1.length)
          )
        for (var k in o)
          if (new RegExp('(' + k + ')').test(fmt))
            fmt = fmt.replace(
              RegExp.$1,
              RegExp.$1.length == 1
                ? o[k]
                : ('00' + o[k]).substr(('' + o[k]).length)
            )
        return fmt
      })
```



# vue网络请求

Vue自己没有对网络请求进行开发，主要是利用其它第三方的库来完成网络请求的处理，比如jQuery的ajax以及axios等

## VUE生命周期

每一个Vue的应用就是一个Vue的实例，此实例有如下特征：

- 通过Vue构造函数创建
- 一个Vue应用由一个通过new Vue创建的根实例以及可选的嵌套的，可复用的组件树组成所有的Vue组件都是Vue实例
- Vue实例创建时的数据对象发生变化时将触发整个视图的“重新渲染”，后添加的属性没有该特性

```html
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Vue实例</title>
  </head>
  <body>
    <div id="app">
      <input v-model="username"/>
    </div>
    <script src="../lib/vue.js"></script>
    <script>
      //定义用户对象，作vue实例的数据
      let user={username:"tom"};

      //创建一个Vue实例
      var vm = new Vue({
        el: '#app',
        data: user,
        updated:function() {  //虚拟DOM重新刷新时的事件
          console.log("视图重新渲染了。");
        }
      });

      console.log(vm.username);  //tom
      console.log(vm.$data===user);  //true
    </script>
  </body>
</html>
```

在浏览器控制台中输出user会发现输出下面的结果

```shell
{__ob__: Observer}
    username: (...)
    __ob__: Observer {value: {…}, dep: Dep, vmCount: 1}
    get username: ƒ reactiveGetter()
    set username: ƒ reactiveSetter(newVal)
    __proto__: Object
```

通过vm.$data或user对象修改其username属性的值会发现引发钩子函数的调用，

```js
user.username="abc"
vm.$data.username="def"
```

但添加新属性会发现不会引起视图重新渲染（Render）。

```js
user.age=18
vm.$data.age=18
```



### 图示

生命周期大致分成4个部分

- 初始化（create）
  - new Vue开始
  - 引发`beforeCreate`和`created`钩子函数
  - 会完成对data中的数据的监听处理
- 挂载（mount）
  - 让Vue实例与其el指定的DOM关联起来，让Vue去管理这一部分DOM
  - 会对el指定的元素进行处理:编译，解析
  - 会引发`beforeMount`和`mounted`
- 更新（update）
  - 主要是视图与数据的双向更新
  - 会引发`beforeUpdate`和`updated`
- 销毁（destroy）
  - 删除Vue实例所占用资源，进行清理操作
  - 会引发`destroyed`钩子函数
  - 通过调用`$destroy()`方法完成销毁

![Vue生命周期图示](https://cn.vuejs.org/images/lifecycle.png)

### 钩子函数

所有的生命周期钩子自动绑定 `this` 上下文到实例中，因此你可以访问数据，对 property 和方法进行运算。这意味着**你不能使用箭头函数来定义一个生命周期方法** (例如 `created: () => this.fetchTodos()`)。这是因为箭头函数绑定了父上下文，因此 `this` 与你期待的 Vue 实例不同，***所以钩子函数不推荐用箭头函数书写***

```html
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>vue2生命周期</title>
    </head>
    <body>
        <div id="app1">
            <input v-model="msg" /> {{msg}}
        </div>
        <button type="button" onclick="destroy()">销毁</button>
        <script src="../lib/vue.js"></script>
        <script type="text/javascript">
            //格式化输出
            console.log("示例：%c%s","background:red;color:#fff","vue生命周期","开始了");
            
            var app1 = new Vue({
                el: "#app1",
                data:{
                    msg:"vue"
                },
                beforeCreate:function(){
                    console.log("创建前："+this.msg);
                },
                created:function(){
                    console.log("创建后："+this.msg+","+this.$el);
                },
                beforeMount:function(){
                    console.log("挂载前：");
                    console.log(this.$el.innerHTML);
                },
                mounted:function(){
                    console.log("挂载后：");
                    console.log(this.$el.innerHTML);
                },
                beforeUpdate:function(){
                    console.log("虚拟DOM（视图）更新前：");
                    console.log(JSON.stringify(this.msg));
                    console.log(this.$el.innerHTML);
                },
                updated:function(){
                    console.log("虚拟DOM（视图）更新后：");
                    console.log(JSON.stringify(this.msg));
                    console.log(this.$el.innerHTML);
                },
                beforeDestroy:function(){
                    console.log("实例销毁前：");
                    console.log(this.msg);                                        
                },
                destroyed:function(){
                    console.log("实例销毁后：");
                    console.log(this.msg);
                }
            });
            
            function destroy(){
                app1.$destroy();
            }
        </script>
    </body>

</html>
```

按以下的顺序观察上面代码的输出

- 打开页面时
- 在文本框中修改值，看看输出情况
- 点击销毁按钮，看看输出情况

总结一下:常用的钩子函数就2个

- `created`：这里可以对数据进行处理，但不要对元素进行操作，此时还没有完成对挂载点完成编译解析处理，也还没有渲染出最终的结果
- `mounted`：既可以处理数据，也可以对元素进行处理

## 天气预报

利用一个开放的API`http://wthrcdn.etouch.cn/weather_mini?city=珠海`来查询实时的天气情况，此API可以直接进行跨域请求

### jQuery实现

```html
<div id="app">
    <input type="text" v-model="city" />
    <input type="button" value="搜索" @click="search" />

    <div id="result">
        <div v-for=" item in result" :key="item.date" class="tianqi">
            <div>{{item.date}}</div>
            <div>{{item.low}}</div>
            <div>{{item.high}}</div>
            <div>{{item.type}}</div>
        </div>
    </div>
</div>
<script src="../lib/vue.js"></script>
<script src="../lib/jquery.js"></script>

<script>
    let vm = new Vue({
        el: '#app',
        data: {
            city: '珠海',
            result: [],
        },
        methods: {
            search: function () {
                let that = this //所以这里需要先用一个变量保存住vue实例
                // let url = 'http://wthrcdn.etouch.cn/weather_mini?city=' + this.city

                $.getJSON(url, function (res) {
                    //this.result 是访问不到上面定义的result变量的，
                    //因为这个函数中的this不是指向vue实例
                    that.result = res.data.forecast
                    console.log(that.result)
                })
            },
        },
    })
</script>
```

如果你想一打开页面就把珠海的天气情况搜索出来，就在created钩子函数里调用search方法

```js
created:function(){
    this.search()
}
```



### axios实现

```html
<div id="app">
    <input type="text" v-model="city" />
    <input type="button" value="搜索" @click="search" />

    <div id="result">
        <div v-for=" item in result" :key="item.date" class="tianqi">
            <div>{{item.date}}</div>
            <div>{{item.low}}</div>
            <div>{{item.high}}</div>
            <div>{{item.type}}</div>
        </div>
    </div>
</div>
<script src="../lib/vue.js"></script>
<script src="../lib/axios.min.js"></script>

<script>
    //***axios的全局配置***
    axios.defaults.baseURL = 'http://wthrcdn.etouch.cn/'
    //***axios添加到Vue原型上***
    Vue.prototype.get = axios.get
    //Vue.prototype.axios = axios
    let vm = new Vue({
        el: '#app',
        data: {
            city: '珠海',
            result: [],
        },
        methods: {
            search: async function () {
                let url = 'weather_mini?city=' + this.city
                /*  this.get(url).then((res) => {
              console.log(res)
              this.result = res.data.data.forecast
              console.log(res.data.data.forecast)
              console.log(this.result)
            }) */

                let res = await this.get(url)
                this.result = res.data.data.forecast
            },
        },
    })
</script>
```



## 网易新闻

在https://www.jianshu.com/p/48f6c2c6f14c有网易API的说明，但此网易接口有跨域问题，需要解决掉跨域的问题。



## 音乐播放器



# 组件

通常一个应用会以一棵嵌套的组件树的形式来组织,例如，你可能会有页头、侧边栏、内容区等组件，每个组件又包含了其它的像导航链接、博文之类的组件。

![组件树](https://cn.vuejs.org/images/components.png)

组件是可复用的 Vue 实例，且带有一个名字,我们可以在一个通过 `new Vue` 创建的 Vue 根实例中，把这个组件作为自定义元素来使用：

## 组件的创建与注册

```js
// 定义一个名为 button-counter 的新组件
Vue.component('button-counter', {
  data: function () {
    return {
      count: 0
    }
  },
  template: '<button v-on:click="count++">You clicked me {{ count }} times.</button>'
})
```

因为组件是可复用的 Vue 实例，所以它们与 `new Vue` 接收相同的选项，例如 `data`、`computed`、`watch`、`methods` 以及生命周期钩子等。仅有的例外是像 `el` 这样根实例特有的选项。

### 全局组件与局部组件

上面就是全局注册了一个组件，名字是button-counter,局部注册的方法，一般是先声明一个组件对象，比如：

```js
var ComponentA = { /* ... */ }
var ComponentB = { /* ... */ }
```

接着再在Vue实例中进行局部的注册

```js
new Vue({
  el: '#app',
  components: {
    'component-a': ComponentA,
    'component-b': ComponentB
  }
})
```



### 组件名

定义组件名的方式有两种：

#### 使用 kebab-case

```js
Vue.component('my-component-name', { /* ... */ })
```

当使用 kebab-case (短横线分隔命名) 定义一个组件时，你也必须在引用这个自定义元素时使用 kebab-case，例如 `<my-component-name>`。

#### 使用 PascalCase

```js
Vue.component('MyComponentName', { /* ... */ })
```

当使用 PascalCase (首字母大写命名) 定义一个组件时，你在引用这个自定义元素时两种命名法都可以使用。也就是说 `<my-component-name>` 和 `<MyComponentName>` 都是可接受的。注意，尽管如此，直接在 DOM (即非字符串的模板) 中使用时只有 kebab-case 是有效的。

### data必须是一个函数

**一个组件的 `data` 选项必须是一个函数**，因此每个实例可以维护一份被返回对象的独立的拷贝：

```js
//不是这样
data: {
  count: 0
}
//而是这样
data: function () {
  return {
    count: 0
  }
}
```

不是函数的话，像下面的示例就会互相影响

```html
<div id="components-demo">
  <button-counter></button-counter>
  <button-counter></button-counter>
  <button-counter></button-counter>
</div>
```

### 单根元素

在编写组件时，现在的vue版本要求有一个根元素，所以你不能像下面这样编写组件

```html
<h2>示例</h2>
<input type="text"/>
```

而应该像下面这样编写

```html
<div>
    <h2>示例</h2>
	<input type="text"/>
</div>
```



## 传递数据给组件

父元素在使用子组件时，如果要从父元素中传递数据给子组件，一般步骤如下：

- 在子组件中通过props声明一些自定义的属性，它是个数组，可以声明任意数量的自定义属性
- 在子组件中使用这些声明的属性
- 在父元素中给子元素的自定义属性赋值，这样数据就传递到了子组件里

子组件中声明属性并使用属性值

```html
Vue.component('blog-post', {
  props: ['title'], 
  template: '<h3>{{ title }}</h3>'
})
```

声明了title这一个属性，并用插值表示的方式使用了属性值

在父元素中如下使用

```html
<blog-post title="My journey with Vue"></blog-post>
<blog-post title="Blogging with Vue"></blog-post>
<blog-post title="Why Vue is so fun"></blog-post>
```

当然，组件的属性也支持动态绑定，比如：

```js
new Vue({
  el: '#blog-post-demo',
  data: {
    posts: [
      { id: 1, title: 'My journey with Vue' },
      { id: 2, title: 'Blogging with Vue' },
      { id: 3, title: 'Why Vue is so fun' }
    ]
  }
})
```



```html
<blog-post
  v-for="post in posts"
  v-bind:key="post.id"
  v-bind:title="post.title"
></blog-post>
```

### 传递对象

我们的博文不只需要标题和内容，还需要发布日期、评论等等。为每个相关的信息定义一个 prop 会变得很麻烦：

```html
<blog-post
  v-for="post in posts"
  v-bind:key="post.id"
  v-bind:title="post.title"
  v-bind:content="post.content"
  v-bind:publishedAt="post.publishedAt"
  v-bind:comments="post.comments"
></blog-post>
```

所以是时候重构一下这个 `<blog-post>` 组件了，让它变成接受一个单独的 `post` 属性：

```html
<blog-post
  v-for="post in posts"
  v-bind:key="post.id"
  v-bind:post="post"
></blog-post>
Vue.component('blog-post', {
  props: ['post'],
  template: `
    <div class="blog-post">
      <h3>{{ post.title }}</h3>
      <div v-html="post.content"></div>
    </div>
  `
})
```

现在，不论何时为 `post` 对象添加一个新的 property，它都会自动地在 `<blog-post>` 内可用。

## 插槽（slot）分发内容

有时组件的内容在组件创建时是不确定的，需要由使用组件的父组件确定下来，这种情况就可以用slot来实现。基本做法是：

- 在子组件中声明一个slot
- 父组件使用此组件时，在子组件中指定内容，这个内容是会替换掉slot

下面的代码就在子组件中声明了一个slot

```js
Vue.component('alert-box', {
  template: `
    <div class="demo-alert-box">
      <strong>Error!</strong>
      <slot></slot>
    </div>
  `
})
```

父组件使用子组件，并在子组件内编写了文本`Something bad happened.`

```html
<alert-box>
  Something bad happened.
</alert-box>
```

最终渲染出的结果如下：

```html
<div class="demo-alert-box">
      <strong>Error!</strong>
      Something bad happened.
</div>
```



## 从组件中接收反馈

通常情况下，子组件发生一些事情是需要父组件知道的，但一般而言子组件不应该直接通过更改父组件的方式来让父组件知道事情发生了，一般都是通过子组件引发事件，父组件监听事情的形式来实现子组件通知父组件。

事件的一般实现方法如下：

- 子组件中通过$emit引发事件
- 父组件通过常规的方式监听事件，比如@custom-event

下面的代码就在子组件中引发了事件`enlarge-text`

```html
<button v-on:click="$emit('enlarge-text')">
  Enlarge text
</button>
```

父组件中使用子组件时监听此事件

```html
<blog-post
  ...
  v-on:enlarge-text="handle"
></blog-post>
```

### 事件参数

有的时候用一个事件来抛出一个特定的值是非常有用的。这时可以使用 `$emit` 的第二个参数来提供这个值：

```
<button v-on:click="$emit('enlarge-text', 0.1)">
  Enlarge text
</button>
```

然后当在父级组件监听这个事件的时候，我们可以通过 `$event` 访问到被抛出的这个值：

```html
<blog-post
  ...
  v-on:enlarge-text="postFontSize += $event"
></blog-post>
```

或者，如果这个事件处理函数是一个方法：

```html
<blog-post
  ...
  v-on:enlarge-text="onEnlargeText"
></blog-post>
```

那么这个值将会作为第一个参数传入这个方法：

```js
methods: {
  onEnlargeText: function (enlargeAmount) {
    this.postFontSize += enlargeAmount
  }
}
```

### 让组件支持v-model

自定义事件也可以用于创建支持 `v-model` 的自定义输入组件。记住：

```html
<input v-model="searchText">
```

等价于：

```html
<input
  v-bind:value="searchText"
  v-on:input="searchText = $event.target.value"
>
```

当用在组件上时，`v-model` 则会这样：

```
<custom-input
  v-bind:value="searchText"
  v-on:input="searchText = $event"
></custom-input>
```

为了让它正常工作，这个组件内的 `<input>` 必须：

- 将其 `value` attribute 绑定到一个名叫 `value` 的 prop 上
- 在其 `input` 事件被触发时，将新的值通过自定义的 `input` 事件抛出

写成代码之后是这样的：

```js
Vue.component('custom-input', {
  props: ['value'],
  template: `
    <input
      v-bind:value="value"
      v-on:input="$emit('input', $event.target.value)"
    >
  `
})
```

现在 `v-model` 就应该可以在这个组件上完美地工作起来了：

```html
<custom-input v-model="searchText"></custom-input>
```

# 附录

## debouncing与throttle

> debounce:防抖，throttle:限流

https://segmentfault.com/a/1190000005926579此页面解释了debouncing与throttle，在lodash中已经实现了这2个功能。在https://cn.vuejs.org/v2/guide/computed.html这个页面中讲解监听器时用到了lodash的debouncing功能。

```js
this.debouncedGetAnswer = _.debounce(this.getAnswer, 500)
```


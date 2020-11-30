// const o = {
//   x: 42,
//   getX: function () {
//     return this.x
//   },
// }

// const unboundGetX = o.getX
// console.log(unboundGetX()) // The function gets invoked at the global scope
// // expected output: undefined
// //unboundGetX.bind()
// const boundGetX = unboundGetX.bind(o)
// console.log(boundGetX())

/* var a = { length: 2, 0: 'first', 1: 'second' } //类数组,有length属性，长度为2，第0个是first，第1个是second
console.log(Array.prototype.slice.call(a, 0)) // ["first", "second"],调用数组的slice(0);

var a = { length: 2, 0: 'first', 1: 'second' }
console.log(Array.prototype.slice.call(a, 1)) //["second"]，调用数组的slice(1);

var a = { 0: 'first', 1: 'second' } //去掉length属性，返回一个空数组
console.log(Array.prototype.slice.call(a, 0)) //[]

function test() {
  console.log(Array.prototype.slice.call(arguments, 0)) //["a", "b", "c"]，slice(0)
  console.log(Array.prototype.slice.call(arguments, 1)) //["b", "c"],slice(1)
}
test('a', 'b', 'c') */

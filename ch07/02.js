console.log('02的开始--------')
export let i = 100 // 单独导出
let j = 200

function add(m, n) {
  return m + n
}

let o = {
  age: 18,
}
//不能在这里再导出i，因为i已经单独导出过了
//export { j, add as sum, i }

export { j, add as sum, o } //集中导出，重命名
/* */

console.log('02的结束*********')

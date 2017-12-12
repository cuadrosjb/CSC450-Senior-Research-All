def c = {
   println it
}
1.upto(10, c)


1.upto(4, {
   println "Number #${it}"
})

0.step 5, 1, {
   println it
}

3.times {
   println "Hello World ${it}"
}
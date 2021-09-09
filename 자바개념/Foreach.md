# Foreach

foreach : 실제적으로 타이핑의 양도 적으면서 가독성도 좋다.

```java
// for문
String[] temp = { "aa", "bb", "cc" };
for (int i = 0; i < temp .length; i++) {
	System.out.println(temp[i]);
}
```

```java
// foreach
String[] temp = { "aa", "bb", "cc" };
for (String el : temp) {
	System.out.println(el);
}
```



foreach의 형태

```
for (type var : iterate) {
	body-of-loop
}
```

> 루프를 돌릴 객체를 iterate 부분에 넣어주고 각 루프에서 나오는 타입과  {} 안에서 사용할 변수명을 var에 지정해 주면 됨. iterate부분에 들어가는 타입은 당연히 루프를 돌릴 수 있는 형태인 Array나 Collections가 가능하고 Iterable<E>를 상속받는 객체 가능함



foreach의 단점

- 루프를 헨들링 할 수 없기 때문에 1스탭씩 순차적으로 반복할 때만 사용함
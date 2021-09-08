# LIST 

**add**

```java
ArrayList pitches = new ArrayList();
prtches.add("138");
pitches.add("129");
pitches.add("142");
```

이 코드는 3번 투구를 138, 129, 142의 속도록 던졌을 때의 코드

> add 라는 메소드를 이용해 투구 스프드 저장



```java
pitches.add(0, "133"); // 첫번째 위치에 133 삽입.
```

> 첫번째 위치에 133을 삽입하고 싶을 때

```java
pithces.add(1, "133"); // 두번째 위치에 133 삽입.
```

> 두번째 위치에 133을 삽입하고 싶을 때



**get**

```java
System.out.println(pitches.get(1));
```

2번째 투구 스피드를 알려주는 코드

> ArrayList의 get 메소드를 이용하면 특정 인덱스의 값을 추출 가능



**size**

```java
System.out.println(pitches.size());
```

ArrayList의 개수를 리턴

> pitches에 담긴 개수에 해당되는 값을 출력



**contains**

```java
System.out.println(pitches.contains("142"));	
```

리스트 안에 항목값이 있는지를 판별하여 그 결과를 boolean으로 리턴

> 142라는 값을 포함하고 있으므로 true 가 출력



**remove**

이름은 같지만 입력파라미터가 다름

- remove(객체)

> remove(객체)의 경우는 리스트에서 객체에 해당되는 항목을 삭제하고 삭제한 결과를 리턴

```java
System.println(pitches.remove("129"));
```

수행결과 : true, "129" 삭제되고 true를 리턴

- remove(인덱스)

> remove(인덱스)의 경우는 해당 인덱스의 항목을 삭제하고 삭제된 항목을 리턴

```java
System.println(pitches.remove(0));
```

수행결과 : 138, "138" 이 삭제 된 후 "138" 을 리턴
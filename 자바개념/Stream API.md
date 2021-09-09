# Stream API

**Stream API**

- 데이터를 추상화하고, 처리하는데 자주 사용되는 함수들을 정의
  - 데이터를 추상화하였다는 것은 데이터의 종류에 상관 없이 같은 방식으로 데이터를 처리 할 수 있다는 것을 의미하며, 그에 따라 재사용성을 높일 수 있음



**Stream 사용 전**

```
// Stream 사용 전
String[] nameArr = { "IronMan", "Captain", "Hulk", "Thor" }
List<String> nameList = Arrays.asList(nameArr);

// 원본의 데이터가 직접 정렬됨
Arrays.sort(nameArr);
Collections.sort(nameList);

for (String str : nameArr) {
	System.out.println(Str);
}

for (String str : nameList) {
	System.out,println(str);
}
```

->

**Stream 사용 후**

```
// Stream 사용 후
String[] nameArr = { "IronMan", "Captain", "Hulk", "Thor" }
List<String> nameList = Arrays.asList(nameArr);

// 원본의 데이터가 아닌 별도의 Stream을 생성함
Stream<String> nameStream = nameList.stream();
Stream<String> arrayStream = Arrays.stream(nameArr);

// 복사된 데이터를 정렬하여 출력함 nameStream.sorted().forEach(System.out::println); arrayStream.sorted().forEach(System.out::println);
```



**사용 후 장점**

- 코드의 라인수를 줄일 수 있음
- 가독성 높임



#### **[Stream API 의 특징]**

( 1 ) 원본의 데이터를 변경하지 않음

- Stream API는 원본의 데이터를 조회하여 원본의 데이터가 아닌 별도의 요소들로 Stream을 생성
- 그렇기 때문에 데이터로부터 읽기만 함
- 정렬이나 필터링 등의 작업은 별도의 Stream 요소들에서 처리

```
List<String> sortedList = nameStream.sorted().collect(Collections.toList());
```



( 2 ) Stream은 일회용

- 한번 사용이 끝나면 재사용이 불가능
- Stream이 또 필요한 경우에는 Stream을 생성해 주어야 함
- 닫힌 Stream을 다시 사용하게 되면 IllegalStateException이 발생



( 3 ) 내부 반복으로 작업을 처리

- 코드가 간결해지는 이유 중 하나는 '내부반복' 때문
- 반복문 forEach라는 함수 내부에 숨겨져 있음



#### **[Stream API]의 연산 종류**

( 1 ) 생성하기

- Stream 객체를 생성하는 단계
- Stream 은 재사용이 불가능하므로, 닫히면 다시 생성

> Stream 연산을 하기 위해서는 먼저 Stream 객체를 생성해주어야 함. 배열, 컬렉션, 임의의 수, 파일 등 거의 모든것을 가지고 스트림을 생성 할 수 있음. 주의할 점은 연산이 끝나면 Stream이 닫히기 때문에, Stream이 닫혔을 경우 다시 생성해야 함



( 2 ) 가공하기

- 원본의 데이터를 별도의 데이터로 가공하기 위한 중간 연산
- 연산 결과를 Stream으로 다시 반환하기 때문에 연속해서 중간 연산을 이어 갈 수 있음

> 가공하기 단계는 원본의 데이터를 별도의 데이터로 가공하기 위한 중간 연산의 단계. 어떤 객체의 Stream을 원하는 형태로 처리 할 수 있으며, 중간 연산의 반환값은 Stream이기 때문에 필요한 만큼 중간 연산을 연결하여 사용 가능



( 3 ) 결과 만들기

- 가공된 데이터로부터 원하는 결과를 만들기 위한 최종 연산
- Stream의 요소들을 소모하면서 연산이 수행되기 때문에 1번만 처리가능



**Stream 연산 예시 코드**

```
List<String> myList = Arrays.asList("a1", "a2", "b1", "c2", "c1");

myList
	.stream()						// 생성하기
	.filter(s -> s.startsWith("c"))	// 가공하기
	.map(String::toUpperCase)		// 가공하기
	.sorted()						// 가공하기
	.count();						// 결과만들기
```

- 이 코드는 Stream() 을 통해 Stream 객체 생성

- 중간 연산이 세미콜론 없이 여러 번 연결되는 것은 해당 중가 연산이 Stream을 반환하기 때문
  - Stream 연산이 연결된 것을 연산 "파이프라인" 이라고 함
- count()를 통해 남아 있는 요소의 갯수를 최종적으로 반환하도록 되어 있음
  - forEach() 와 같이 반환하지 않는 최종 연산도 존재

 
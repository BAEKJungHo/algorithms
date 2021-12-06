# 동적 계획법(Dynamic Programming)

메모리 공간을 약간 더 사용해서 연산 속도를 비약적으로 증가시키는 방법이 있는데 대표적인 방법에 `동적 계획법(Dynamic Programming)`이 있다. 다이나믹 프로그래밍 방식은 `TopDown` and `BottomUp` 두 가지가 있으며
메모이제이션 기법을 자주 사용한다.

다이나믹 프로그래밍으로 해결할 수있는 대표적인 예시가 `피보나치 수열`이다.

> 메모이제이션 기법을 사용하여 피보나치 수열을 구현한 예시는 [여기](https://github.com/BAEKJungHo/algorithms/tree/master/contents/DataStructures/Stack/Recursive#%EB%A9%94%EB%AA%A8%EC%9D%B4%EC%A0%9C%EC%9D%B4%EC%85%98memoization)를 확인하자.
> 본인이 재귀에 대한 이해가 부족하다면 위 링크를 통해 배우는 것을 추천한다.

재귀에서 배웠듯이 재귀를 사용하려면 점화식을 작성해보는 것이 좋다. 피보나치 수열에 대한 점화식은 다음과 같다.

$$a_{n}= a_{n-1} + a_{n-2}, a_{1} = 1, a_{2} = 1$$  

$$x = {-b \pm \sqrt{b^2-4ac} \over 2a}$$

$x = {-b \pm \sqrt{b^2-4ac} \over 2a}$

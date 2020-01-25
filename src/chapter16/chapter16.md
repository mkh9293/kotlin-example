### chapter16 : 인터페이스와 추상 클래스  

---

코틀린에서 인터페이스와 추상클래스의 차이가 뭘까..  

1. 인터페이스는 필드를 가질 수 없다.
2. 클래스는 인터페이스 여러개를 구현 가능, 추상 클래스는 하나만 상속 가능
3. 인터페이스에는 생성자가 없음

추상 클래스는 말그대로 클래스를 추상화 한것으로 하나의 클래스와 비슷한 개념으로 볼 수 있지만,  
인터페이스는 뜻 그대로 여러 클래스들의 같은 동작을 나타내기 위해 사용한다.  
(인스턴스 생성 못하는건 추상클래스나 인터페이스 똑같음.)

%% 책 내용   
인터페이스 : 서로 다른 객체 간에 개념적으로 상속 관계가 없으면서 공통적인 속성이나 행동을 갖는 경우  
추상클래스 : 상속 관계가 있으면서 인스턴스 생성이 필요 없는 슈퍼 클래스가 필요한 경우  
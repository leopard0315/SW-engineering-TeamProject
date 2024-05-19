# DoCodeReview

![DoCodeReview drawio](https://github.com/choi-hyk/SW-engineering-TeamProject/assets/95125109/aa644b76-5bcf-43ba-8c3b-caa7e3581cd0)

### 해당 클래스 다이어그램은 다른 사용자의 브랜치에 접근하여 상대방이 작성해놓은 코드를 수정하여 상대방에게 전송하는 기능을 정의합니다. 사용자는 코드리뷰를 원하는 부분을 우클릭하여 코드리뷰를 실시한 후 상대방에게 전송합니다.

### 팀 과제 #4에서 사용한 부분
#### IDE_ClassDiagram에서 DoCodeScript클래스를 구체화하였습니다.

### 사용 패턴 : 행동 패턴 - Command

### 사용 이유 : Command패턴은 여러 단계의 복잡한 트랜잭션이나 작업을 관리할 때 유용합니다. DoCodeReview클래스 다이어그램은 코드리뷰 하는 작업과 상대방에게 전송할 때 알림을 보내는 기능을 독립적인 Command객체로 나눌 필요가 있다고 생각했습니다. 이로인해 복잡한 동작을 간단하게 실행할 수 있습니다.
<br/><br/>
# 리뷰
## Command class: ReviewCommand
## ConcreteCommand class : EditCodeCommand, NotifyUserCommand
<br/><br/>
## ReviewCommand
해당 클래스는 코드 리뷰를 하기위한 인터페이스들을 선언합니다. 
<br/><br/>
## EditCodeCommand, NotifyUserCommand
해당 클래스들은 ReviewCommand에서 처리된 연산을 호출하도록 Execute를 구현합니다.
<br/><br/>
## 사용방법
사용자는 해당 클래스를 통해 LiveCodeScript환경에서 코드리뷰를 실시하여 다른 사용자에게 보내고 알림을 전송합니다.

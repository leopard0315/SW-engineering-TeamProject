## CodeReviewerManage

![CodeReviewerManage drawio](https://github.com/choi-hyk/SW-engineering-TeamProject/assets/95125109/fb20da76-4482-4f9e-89e4-28bd8f6af14c)

#### 해당 클래스 다이어그램은 코드리뷰를 전송받았을 때 받은 리뷰를 관리하는 기능을 정의합니다. 사용자는 리뷰받은 코드를 적용하거나 거절할 수 있으며 해당 기능 수행 시, 리뷰를 전송한 사용자에게 알림을 다시 보냅니다.

### 팀 과제 #4에서 사용한 부분
#### 사용 패턴 : 행동 패턴 - state

### 사용 이유
#### 사용자는 리뷰받은 코드를 적용할 수도 있고 거부할 수도 있습니다. 
적용할 경우에는 적용할 때의 행동이 있을 것이고, 거부 시 행동 또한 있을 것입니다. state패턴을 사용하여 위 두가지의 상태를 캡슐화하여 보다 쉽게 관리하고, 책임을 명확히 분리할 수 있습니다.
<br/><br/>
# 리뷰
### Context class : CodeReviewerManage
### State class : ReviewState
### ConcreteState class : PendingReviewState, ApprovedReviewState, RejectedReviewState
<br/><br/>
## CodeReviewerManage
해당 클래스는 리뷰 상태를 정의한 ConcreteState 서브클래스들의 인스턴스를 관리합니다.
<br/><br/>
## ReviewState
해당 클래스는 리뷰 상태별로 필요한 행동들을 캡슐화하여 인터페이스로 정의합니다.
<br/><br/>
## PendingReviewState, ApprovedReviewState, RejectedReviewState
해당 클래스들은 상태에 따라 처리되어야 할 행동들을 구현합니다.
리뷰가 보류중인 상태, 리뷰를 적용할 상태, 리뷰를 거부하는 상태로 나뉘어져 있습니다.
<br/><br/>
## 사용방법
사용자는 해당 클래스를 통해 리뷰가 온 코드들을 찬성 또는 거부할 수 있습니다. 해당 기능을 수행하고 알림을 다시 보냅니다.



# LiveCodeScript

![LiveCodeScript](https://github.com/choi-hyk/SW-engineering-TeamProject/assets/95125109/26f5cb6e-72fa-4071-84e2-8502d212bdd3)


### 해당 클래스 다이어그램은 다른 사용자의 브랜치에 접근하여 해당 사용자의 접속 상태에 따라 스크립트를 작성하는 기능을 사용할 수 있습니다. 상대방의 접속상태가 온라인일 경우 상대방의 라이브 스크립트를 사용가능하고 오프라인일 경우 불가능하게 설정하였습니다.

### 팀 과제 #4에서 사용한 부분
#### IDE_ClassDiagram에서 LiveCodeScript클래스를 구체화했습니다.

### 사용 패턴 : 행동 패턴 - state

### 사용 이유 : LiveCodeScript는 사용자의 온라인 상태와 오프라인 상태에 따라 사용가능한 기능이 다르므로 동작이 달라야 합니다. 온라인 상태에서는 스크립트를 수정하고 접근할 수 있고, 오프라인 상태에서는 이러한 기능이 제한되어야 합니다. State 패턴을 사용하면 이러한 상태에 따른 행동 변화를 효과적으로 관리할 수 있기에 사용하였습니다. 또한 State패턴을 사용하면 online과 offline일 때의 각 상태 클래스 내에 캡슐화할 수 있으므로 상태 변경을 보다 쉽게 관리하고, 각 상태의 책임을 명확히 분리할 수 있습니다.
<br/><br/>
# 리뷰
### Context class : Context
### State class : State
### ConcreteState class : onlinestate, offlinestate
<br/><br/>
## Context
해당 클래스는 ConcreteState 서브클래스의 인스턴스를 유지, 관리합니다.
<br/><br/>
## State
해당 클래스는 Context의 각 상태별로 필요한 행동으로 캡슐화하여 인터페이스로 정의합니다.
<br/><br/>
## onlinestate, offlinestate
해당 클래스들은 Context의 상태에 따라 처리되어야 할 실제 행동을 구현합니다.
온라인 상태인 경우와 오프라인 상태의 경우 처리해야하는 행동을 각각 다르게 구현해야 합니다.
<br/><br/>
## 사용방법
사용자는 해당 클래스를 통해 라이브 코드 스크립트를 사용할 수 있습니다. onlinestate와 offlinestate일 때 사용할 수 있는 기능이 달라집니다.

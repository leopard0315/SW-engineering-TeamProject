# TeamSpace
## ![TeamSpace_ClassDiagram drawio](https://github.com/choi-hyk/SW-engineering-TeamProject/assets/127075917/c35969c7-e503-4f39-8b23-12a302fbf51c)

####  해당 클래스 집합은 유저한테 팀 스페이스 인터페이스를 제공하고 데이터 공유 및 관리, 팀 멤버 관리, 팀 스페이스 설정 그리고 UML, 문서, 그래프, 일정 관리 등 여러가지 도구를 사용할 수 있는 함수를 나타냅니다.  
### 사용 패턴 : 구조 패턴 - Composite
#### 사용 이유 : 팀 스페이스가 보유하고 있는 여러가지의 기능들을 단일 객체로 구현하는데 많은 어려움이 존재했습니다. 따라서 같은 계층에 있는 단일 객체들의 기능을 보유하고 있는 복합 객체를 생성하여 트리 구조로 나타내는 복합체(Composite) 패턴으로 구현했습니다. 또한 도구(Tool) 기능 같은 하위 계층의 객체또한 복합체로 나타내서 보다 용이하게 구현 가능하여 해당 패턴을 사용하였습니다.
<br/><br/>
## 리뷰
#### Component class : SystemComponent, ToolSystem
#### Composite class : ToolComponent, ToolSystem
#### Leaf class : ManageSystem, MemberSystem, UMLTool, ScheduleTool, GraphTool, DocumentTool
<br/><br/>
## SystemComponent
해당 클래스는 TeamSpace 첫번째 계층 클래스 들의 집합인 TeamSapce, ToolComponent, ManageSystem, MemberSystem 클래스 들의 인터페이스를 정의합니다. 따라서 해당 시스템들에 접근하는 기능을 제공합니다. 따라서 해당 클래스는 TeamSpace에게 같은 계층의 시스템 클래스들을 리스트 형식으로 제공합니다.
<br/><br/>
## TeamSpace
해당 클래스는 첫번째 계층의 복합 객체로 ToolComponent, ManageSystem, MemberSystem 클래스들의 기능을 보유하며 SystemComponent에서 유저가 접근 가능하도록 합니다.
<br/><br/>
##  ManageSystem, MemberSystem
해당 클래스들은 첫번째 계층의 단일 객체를 나타내며 TeamSpace를 위한 기능을 정의합니다.
<br/><br/>
## ToolComponent
해당 클래스는 첫번째 계층의 컴포넌트와 단일 객체이며 이와 동시에 두번째 계층의  UMLTool, ScheduleTool, GraphTool, DocumentTool의 기능들을 보유하고 유저에게 ToolSystem을 통해 해당 기능을 사용 가능하도록 합니다. 따라서 해당 클래스는 ToolSystem에게 같은 계층의 도구 클래스들을 리스트 형식으로 제공합니다.
<br/><br/>
## 사용방법
사용자는 TeamSpace에서 SystemComponent로 부터 복합체가 구현된 components 멤버 변수로 해당 시스템의 함수들을 이용 가능합니다. 이때 ToolComponent는 트리 구조로 또 다른 계층 형태의 기능을 보유하므로 사용자가 만약 도구를 사용하고 싶다면 acessComponent를 통해 도구에 접근을 한 후 마찬가지로 ToolSystem에서 특정 도구를 사용하여 acessTool을 이용 가능합니다.

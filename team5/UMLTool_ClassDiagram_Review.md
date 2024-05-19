# UMLTool
![UMLTool_ClassDiagram drawio](https://github.com/choi-hyk/SW-engineering-TeamProject/assets/127075917/3d1b6bb8-7f76-4a75-a95f-7f1e77b671cb)

####  해당 클래스 다이어그램은 도구 기능 중 UML 기능을 제공하는 클래스들을 정의합니다. 사용자는 해당 클래스들을 이용하여 5가지 UML 유스케이스 다이어그램, 엑티비티 다이어그램, 클래스 다이어그램, 상태기계 다이어그램, 순차 다이어그램을 사용 가능합니다.
### 팀 과제 #4 에서 사용한 부분
#### TeamSpace_ClassDiagram의 UMLTool과 UML을 구성하는 요소인 Diagram과 Arrow을 사용하였습니다. UMLTool을 단순히 요소를 정의하는 것이 아닌 5가지의 UML종류인  UseCaseDiagram, ActivityDiagram, ClassDiagram, StateMachineDiagram, SequenceDiagram 5개의 클래스로 나눴습니다. 또한 Diagram과 Arrow 클래스는 함수로 구현했습니다. 
### 사용 패턴 : 생성 패턴 - Factory Method
### 사용 이유
#### 펙토리 메소드 패턴은 객체 생성은 미리 하지만 해당 객체가 어떠한 기능을 제공하는 객체인지는 서브 클래스가 정의합니다. 따라서 다양한 UML을 제공하는 해당 구조에서는 공통된 기능의 집합을 제공하는 상위 클래스를 먼저 정의한 후 서브 클래스에서 해당 UML이 어떤 종류의 UML인지 정의할 필요가 있습니다. 또한 사용자는 다이어그램을 생성하고 화살표를 그리며 텍스트를 삽입하는 모든 UML툴의 공통된 기능을 특정 UML펙토리에서 생성한 객체에 따라 구체적인 기능(특정 UML에 따른 차별화된 기능)으로 사용 가능합니다. 이러한 이유로 펙토리 메소드 패턴을 선택하였습니다.
<br/><br/>
# 리뷰
### Creator class : UMLFactory
### Concrete Creator class : UseCaseDiagramFactory, ActivityDiagramFactory, ClassDiagramFactory, StateMachineDiagramFactory, SequenceDiagramFactory
### Product class : UMLElement
### Concrete Product class : UseCaseDiagram, ActivityDiagram, ClassDiagram, StateMachineDiagram, SequenceDiagram
<br/><br/>
## UMLFactory
해당 클래스는 UML을 생성하는 Creator 클래스 입니다. 사용자는 해당 클래스의 createDiagram을 통해 원하는 UML을 생성 가능합니다.
<br/><br/>
## Concrete Creator(UseCaseDiagramFactory, ActivityDiagramFactory, ClassDiagramFactory, StateMachineDiagramFactory, SequenceDiagramFactory)
해당 클래스들은 createDiagram으로 특정 객체가 생성 되면 UML이 제공하는 공통 기능인 UMLElements클래스의 기능들을 사용 가능하도록 합니다.
<br/><br/>
## UMLElement
해당 클래스는 UML의 공통된 기능을 제공하는 Product클래스이며 추상 함수를 통해 특정 UML이 해당 함수를 구체화하여 사용 가능하도록 합니다.
<br/><br/>
## Concrete Product(UseCaseDiagram, ActivityDiagram, ClassDiagram, StateMachineDiagram, SequenceDiagram)
해당 클래스들은 Creator로 생성된 UML의 특정 기능을 제공합니다. 따라서 특정 UML마다 공통된 기능을 구체화하여 기능을 제공합니다.
<br/><br/>
## 사용방법
사용자는 UML 도구를 사용하여 UML객체를 만듭니다. 이때 어떠한 UML을 만들지 선택한 후 만들어진 객체를 통해 inputText, addDiagram, linkArrow 등 공통된 기능을 사용 가능합니다. 또한 UML을 추가할때 해당 UML의 Factory와 Prodcut함수만 구현하면 되므로 확장에도 용이 합니다.

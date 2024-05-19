# UMLCodeLinking
![UMLCodeLinking_ClassDiagram drawio](https://github.com/choi-hyk/SW-engineering-TeamProject/assets/127075917/0ba25ed9-9063-4e1f-b0c0-1a2285ef8078)

####  해당 클래스 집합은 코드와 UML을 탐색하여 공통된 클래스들을 연결하는 기능을 정의합니다. 사용자는 해당 클래스들을 사용하여 UML과 코드를 연결 가능하고 연결한 후 데이터를 동기화 하여 수정 및 구현을 통해 UML 또는 코드를 업데이트 가능합니다.
### 사용 패턴 : 생성 패턴 - Mediator
### 사용 이유
#### 중재자(Mediator) 패턴은 서로 공유하는 기능을 제공하는 객체들이 직접 참조를 하지 않게 하여 결합도를 낮추고 상호작용을 독립적으로 사용 가능하게 합니다. 따라서 UMLData와 CodeData는 서로 일치 시킬 수 있는 데이터가 존재하지만 서로 직접 참조를 할 경우 많은 문제가 발생 가능합니다. 이때 중재자 패턴을 활용하여 해당 클래스들을 Colleague클래스에서 연결한 후 연결한 데이터를 Mediator클래스로 전송하여 Linking기능을 사용하도록 구현할 수 있습니다. 이러한 이유로 해당 패턴을 선택하였습니다. 
<br/><br/>
# 리뷰
### Colleague class : LinkedData
### Concrete Colleague class : UMLData, CodeData
### Mediator class : LinkingMediator
### Concrete Mediator class: UMLCodeLinking
<br/><br/>
## LinkedData
해당 클래스는 UMLData와 CodeData클래스를 통해 두 개의 데이터 객체를 탐색하여 연결합니다. 사용자는 해당 클래스를 통해 UML페이지 또는 code script 페이지에서 일치하는 데이터를 탐색 가능하고 식별된 링킹 데이터는 LinkingMediator로 전송되어서 Linking기능을 사용 가능하도록 합니다.
<br/><br/>
## UMLData, CodeData
해당 클래스들은 각각 UML 데이터, Code 데이터를 정의하고 각 페이지 마다 해당 데이터와 일치하는 데이터를 탐색하는 함수를 제공합니다. 이 함수를 통해 LinkedData에서 연결된 데이터를 Mediator로 전송합니다.
<br/><br/>
## LinkingMediator
해당 클래스는 연결된 데이터를 LinkedData로 부터 전송 받아서 linking 기능을 사용자가 사용 가능하도록 합니다. 
<br/><br/>
## UMLCodeLinking
해당 클래스는 연결 LinkingMediator의 함수를 구체화 하고 연결된 기능이 UMLData또는 CodeData에 영향을 미칠 경우 해당 데이터 수정을 알리고 적용 시킵니다.
<br/><br/>
## 사용방법
사용자는 해당 클래스를 통해 UML 또는 code script페이지에서 일치하는 데이터를 탐색 가능합니다. 일치하는 데이터가 탐색되면 사용자는 해당 데이터를 수정하거나 삭제하는 등 여러가지 기능을 통해 UMLData 또는 CodeData의 데이터 일관성을 유지할 수 있습니다.

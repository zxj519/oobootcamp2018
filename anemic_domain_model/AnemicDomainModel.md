# AnemicDomainModel 贫血模型

`The basic symptom of an Anemic Domain Model is that at first blush it looks like the real thing. There are objects, many named after the nouns in the domain space, and these objects are connected with the rich relationships and structure that true domain models have. The catch comes when you look at the behavior, and you realize that there is hardly any behavior on these objects, making them little more than bags of getters and setters.  —— 2003 Martin Fowler`

`贫血模型一个明显的特征是它仅仅是看上去和领域模型一样，都拥有对象、属性、对象间通过关系关联。但是当你观察模型所持有的业务逻辑时，你会发现，贫血模型中除了一些getter和setter方法，几乎没有其他业务逻辑。—— http://www.ituring.com.cn/article/25`

**Anemic Domain Model Example**
```java
public class Inspection {
  
  private UUID inspectionId;
  private InspectionType inspectionType;
  private Long propertyId;
  private String note;
  private LocalDateTime scheduledStartDateTime;
  private LocalDateTime scheduledEndDateTime;
  private Long inspectorUserId;
  private LocalDateTime inspectedDateTime;
  private InspectionStatus status;

  //Getters
  
  //Setters
}

public class AreaReview {
  
}

public class InspectionService {
  //...
  
  public void markInspectionAsInspected(UUID inspectionId) {
    Inspection inspection = inspectionRepository.findOneOrThrow(inspectionId);
    if(InspectionStatus.CLOSED.equals(inspeciton.getStatus)) {
      throw new InspectionAlreadyClosedException();
    }
    if(InspectionStatus.SCHEDULED.equals(inspeciton.getStatus)) {
      throw new InvalidInspectionStatusChangeException();
    }
    inspection.setStatus(InspectionStatus.INSPECTED);
    inspection.setInspectedDateTime(LocalDateTime.now());
    inspectionRepository.save(inspection);
  }
  
  
  
  //...
}
```

**Rich Domain Model Example**

```java
public class Inspection {
  
  private UUID inspectionId;
  private InspectionType inspectionType;
  private Long propertyId;
  private String note;
  private LocalDateTime scheduledStartDateTime;
  private LocalDateTime scheduledEndDateTime;
  private Long inspectorUserId;
  private LocalDateTime inspectedDateTime;
  private InspectionStatus status;

  public void markAsInspected() {
    if(InspectionStatus.CLOSED.equals(this.status)) {
      throw new InspectionAlreadyClosedException();
    }
    if(InspectionStatus.SCHEDULED.equals(this.tatus)) {
      throw new InvalidInspectionStatusChangeException();
    }
    this.status = InspectionStatus.INSPECTED;
    this.inspectedDateTime = LocalDateTime.now();
  }
  
  //Getters
  //Setters
  //...
}

public class InspectionService {
  //...
  public void markInspectionAsInspected(UUID inspectionId) {
    Inspection inspection = inspectionRepository.findOneOrThrow(inspectionId);
    inspection.markAsInspected();
    inspectionRepository.save(inspection);
  }
  
  public void addAreaReview(AddAreaReivewCommand command) {
      Inspection inspection = inspectionRepository.findOneOrThrow(command.inspectionId);
      AreaReview review = new AreaReview(
          command.inspectionId,
          command.areaId,
          command.comment);
      areaReviewRepository.save(review);
      inspection.startInspection();
      inspectionRepository.save(inspection);
    }
  //...
}
```


**Reference Link**
* https://www.martinfowler.com/bliki/AnemicDomainModel.html
* http://www.ituring.com.cn/article/25
* http://www.ituring.com.cn/article/125

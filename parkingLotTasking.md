```gherkin

Feature: 停车场
  Scenario: 停车入场
    Given: 停车场有剩余车位
    When: 车辆进入停车场
    And: 生成停车票
    And: 停车成功
    
    Given: 停车场没有剩余停车位
    When: 车辆进入停车场
    Then: 无法生成停车票 
    And: 无法进入停车场
    
  Scenario: 车辆出场
    Given: 我的车停在停车场
    And: 我有停车票
    When: 凭票取车
    Then: 成功取出我的车

Feature: 停车小弟
  Scenario: 小弟停车
    Given: 有个停车场
    And: 停车场有停车位
    When: 小弟停车
    Then: 成功将车辆停到停车场
    
    Given: 有两个只有一个停车位的停车场
    And: 有两辆需要停放的车
    When: 小弟停车
    Then: 能成功将两辆车停到停车场
    
    Given: 有两个停车场
    And: 两个停车场都满了
    When: 小弟停车
    Then: 停车失败
  
  Scenario: 小弟取车
    Given: 有2个停车场
    And: 有一辆车停在第一个停车场
    When: 小弟取车
    Then: 成功取车
    
    Given: 有2个停车场
    And: 有一辆车停在第二个停车场
    When: 小弟取车
    Then: 成功取车
    
    Given: 有一个停车场
    And: 小弟停了一辆车到停车场
    When: 小弟用另外一张票取车
    Then: 取车失败
   

```
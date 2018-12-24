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

```
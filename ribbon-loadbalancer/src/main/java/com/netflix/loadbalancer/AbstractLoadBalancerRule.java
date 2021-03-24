/*
*
* Copyright 2013 Netflix, Inc.
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
* http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*
*/
package com.netflix.loadbalancer;

import com.netflix.client.IClientConfigAware;

/**
 * Class that provides a default implementation for setting and getting load balancer
 * @author stonse
 *
 负载均衡算法
    1. roundRobinRule算法
        1). 选择一台机器,如果不可用,往复调用十次
        2). 如果十次完毕还不可用,则选择用RoundRobin算法下一台继续调用十次
    2. AvailabilityFilteringRule算法
        1). 选择一台机器,如果不可用,往复调用十次
        2). 如果十次完毕还不可用,则选择用RoundRobin算法下一台继续调用十次
    3. BestAvailableRule算法
        1). 查看是否服务器故障
        2). 尽量请求最少的服务器
    4. RandomRule
        1. 随机找一台服务器
        2. 尽量随机分散到所有服务器上
    5. RetryRule算法
        1). 先基于RoundRobin找一台
        2). 如果服务器不可用,则再次选择一台
    6.  WeightedResponseTimeRule算法
        1). 每台机器都带着权重
        2). 权重越高,越优先访问
    7. ZoneAvoidanceRule
        1).根据机房进行负载均衡选择
 *
 */
public abstract class AbstractLoadBalancerRule implements IRule, IClientConfigAware {

    private ILoadBalancer lb;
        
    @Override
    public void setLoadBalancer(ILoadBalancer lb){
        this.lb = lb;
    }
    
    @Override
    public ILoadBalancer getLoadBalancer(){
        return lb;
    }      
}

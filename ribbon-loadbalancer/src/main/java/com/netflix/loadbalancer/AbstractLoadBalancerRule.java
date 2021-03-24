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
 ���ؾ����㷨
    1. roundRobinRule�㷨
        1). ѡ��һ̨����,���������,��������ʮ��
        2). ���ʮ����ϻ�������,��ѡ����RoundRobin�㷨��һ̨��������ʮ��
    2. AvailabilityFilteringRule�㷨
        1). ѡ��һ̨����,���������,��������ʮ��
        2). ���ʮ����ϻ�������,��ѡ����RoundRobin�㷨��һ̨��������ʮ��
    3. BestAvailableRule�㷨
        1). �鿴�Ƿ����������
        2). �����������ٵķ�����
    4. RandomRule
        1. �����һ̨������
        2. ���������ɢ�����з�������
    5. RetryRule�㷨
        1). �Ȼ���RoundRobin��һ̨
        2). ���������������,���ٴ�ѡ��һ̨
    6.  WeightedResponseTimeRule�㷨
        1). ÿ̨����������Ȩ��
        2). Ȩ��Խ��,Խ���ȷ���
    7. ZoneAvoidanceRule
        1).���ݻ������и��ؾ���ѡ��
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

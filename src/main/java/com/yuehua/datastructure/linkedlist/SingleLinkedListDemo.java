package com.yuehua.datastructure.linkedlist;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 单向链表
 */
public class SingleLinkedListDemo {
    public static void main(String[] args) throws Exception {
        // 测试
        // 创建节点  没有考虑排名
//        HeroNode heroNode = new HeroNode(1, "宋江", "及时雨", null);
//        HeroNode heroNode1 = new HeroNode(2, "卢俊义", "玉麒麟", null);
//        HeroNode heroNode2 = new HeroNode(3, "吴用", "智多星", null);
//        HeroNode heroNode3 = new HeroNode(4, "林冲", "豹子头", null);
//        SingleLinkedList singleLinkedList = new SingleLinkedList();
//        singleLinkedList.addNode(heroNode);
//        singleLinkedList.addNode(heroNode2);
//        singleLinkedList.addNode(heroNode1);
//        singleLinkedList.addNode(heroNode3);
//        singleLinkedList.listNode();

        HeroNode heroNode1 = new HeroNode(1, "宋江", "及时雨", null);
        HeroNode heroNode3 = new HeroNode(3, "吴用", "智多星", null);
        HeroNode heroNode4 = new HeroNode(4, "林冲", "豹子头", null);
        HeroNode heroNode2 = new HeroNode(2, "卢俊义", "玉麒麟", null);
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.addByOrder(heroNode1);
        singleLinkedList.addByOrder(heroNode2);
        singleLinkedList.addByOrder(heroNode4);
        singleLinkedList.addByOrder(heroNode3);
//        singleLinkedList.addByOrder(heroNode3);
//        singleLinkedList.addByOrder(heroNode4);

//        singleLinkedList.addByOrder(heroNode3);
//        singleLinkedList.listNode();

        // 测试修改节点
        singleLinkedList.listNode();
        singleLinkedList.updateHeroNode(new HeroNode(3, "有用", "大猩猩", null));
        System.out.println("修改后");
        singleLinkedList.listNode();


        System.out.print("删除前");
        singleLinkedList.listNode();
        singleLinkedList.deleteHero(3);
        singleLinkedList.deleteHero(1);
//        singleLinkedList.deleteHero(4);
//        singleLinkedList.deleteHero(2);
//        singleLinkedList.deleteHero(2);
        System.out.println("删除后");
        singleLinkedList.listNode();


        System.out.println(singleLinkedList.length(singleLinkedList.getHead()));


    }
}

// 定义HeroNode,每个HeroNode 对象就是一个节点
@Data
@AllArgsConstructor
@NoArgsConstructor
class HeroNode {
    // 编号
    public Integer no;
    public String name;
    public String nickName;

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }

    public HeroNode next;

}

class SingleLinkedList {
    // 初始化一个头节点，不能动，不存放具体的数据
    private HeroNode head = new HeroNode(0, null, null, null);

    /**
     * 添加节点到单向链表
     * 思路：
     * 1.找到当前链表的最后一个节点
     * 2.将最后这个节点的next 指向新的节点
     *
     * @param headNode
     */
    public void addNode(HeroNode headNode) {
        HeroNode temp = head;
        while (true) {
            if (temp.next == null) {
                temp.next = headNode;
                break;
            }
            temp = temp.next;
        }
    }

    public void listNode() {
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        HeroNode temp = head.next;
        while (true) {
            if (temp == null) {
                break;
            }
            System.out.println(temp.toString());
            temp = temp.next;
        }
    }

    /**
     * 按照顺序加入链表 需要循环获取
     * 1.加入到哪里
     * 2.怎么加入
     */
    public void addByOrder(HeroNode hero) throws Exception {
        if (hero == null || hero.no == null) {
            throw new Exception(hero.toString() + "为空");
        }
        HeroNode temp = head;
        // 退出循环的标志
        boolean flag = false;
        while (true) {
            // 循环到最后一个节点，退出
            if (temp.next == null) {
                break;
            }
            // 已经加入成功活着 存在了 也要退出
            if (temp.no == hero.no) {
                flag = true;
                break;
            }
            // 找到了
            if (temp.next.no > hero.no) {
                break;
            }
            temp = temp.next;

        }
        if (flag) {
            System.out.println("英雄=>" + hero.toString() + "已经存在，不能加入");
        } else {

            hero.next = temp.next;
            temp.next = hero;
        }
    }


    public HeroNode getHead() {
        return head;
    }

    public void updateHeroNode(HeroNode newHeroNode) throws Exception {
        if (newHeroNode == null || newHeroNode.no == null) {
            throw new Exception("英雄节点为空");
        }
        HeroNode temp = head;
        // 是否找到要修改的节点
        boolean flag = false;
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.no == newHeroNode.no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.name = newHeroNode.name;
            temp.nickName = newHeroNode.nickName;
        } else {
            System.out.println("没找到节点" + newHeroNode.toString());
        }


    }

    public void deleteHero(Integer no) {
        HeroNode temp = head;
        boolean falg = false;
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.no == no) {
                falg = true;
                break;
            }
            temp = temp.next;
        }
        if (falg) {
            temp.next = temp.next.next;
        } else {
            System.out.printf("没有找到%d要删除的节点", no);
        }
    }

    // 面试题目： 单链表有效节点的个数
    public Integer length(HeroNode head) {
        Integer length = 0;
        if (head.next == null) {
            return length;
        }
        HeroNode currentNode = head.next;
        while (currentNode != null) {
            length++;
            currentNode = currentNode.next;
        }
        return length;

    }


}
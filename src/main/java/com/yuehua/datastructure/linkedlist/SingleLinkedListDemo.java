package com.yuehua.datastructure.linkedlist;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 单向链表
 */
public class SingleLinkedListDemo {
    public static void main(String[] args) {
        // 测试
        // 创建节点  没有考虑排名
        HeroNode heroNode = new HeroNode(1, "宋江", "及时雨", null);
        HeroNode heroNode1 = new HeroNode(2, "卢俊义", "玉麒麟", null);
        HeroNode heroNode2 = new HeroNode(3, "吴用", "智多星", null);
        HeroNode heroNode3 = new HeroNode(4, "林冲", "豹子头", null);
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.addNode(heroNode);
        singleLinkedList.addNode(heroNode2);
        singleLinkedList.addNode(heroNode1);
        singleLinkedList.addNode(heroNode3);
        singleLinkedList.listNode();

    }
}

// 定义HeroNode,每个HeroNode 对象就是一个节点
@Data
@AllArgsConstructor
@NoArgsConstructor
class HeroNode {
    // 编号
    private int no;
    private String name;
    private String nickName;

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

}
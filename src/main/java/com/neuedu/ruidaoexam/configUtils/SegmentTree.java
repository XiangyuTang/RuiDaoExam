package com.neuedu.ruidaoexam.configUtils;

import java.util.Scanner;

/*问题描述

有n个格子，从左到右放成一排，编号为1-n。
共有m次操作，有3种操作类型：
1.修改一个格子的权值，
2.求连续一段格子权值和，
3.求连续一段格子的最大值。

对于每个2、3操作输出你所求出的结果。
输入格式

第一行2个整数n，m。

接下来一行n个整数表示n个格子的初始权值。

接下来m行，每行3个整数p,x,y，p表示操作类型，p=1时表示修改格子x的权值为y，p=2时表示求区间[x,y]内格子权值和，
p=3时表示求区间[x,y]内格子最大的权值。
输出格式

有若干行，行数等于p=2或3的操作总数。

每行1个整数，对应了每个p=2或3操作的结果。
样例输入
4 3
1 2 3 4  //每个a[i]里人
2 1 3 //求【1，3】内权值和
1 4 3
3 1 4
样例输出
6
3

1 <= n <= 100000，m <= 100000，0 <= 格子权值 <= 10000
*/
/*
 * 思路回顾
 * 建树操作：三个参数，idx,总区间l，r,从idx=0的根结点开始操作,先初始化node[idx] = new Node(l,r)
 * 		如果l==r,把node[idx] = a[l]或者a[r]，否则mid,递归创建左右孩子树make(l,mid,idx<<1|1);make(mid+1,r,(idx<<1)+2);
 * 		建完了回溯更新父亲结点的信息
 * 查询操作：有两个区间参数，表示左右区间，一个idx参数表示正在当前结点node[idx]操作
 * 		如果当前结点的区间被包含在查询区间内，则直接加上当前结点区间的sum或者max，否则mid，判断需要查左边，右边还是两边都查
 * 单点更新操作：参数：点的位置i,当前结点node位置idx，更新值val
 * 		如果当前node[idx]的左右区间都是i,则更新它
 * 		否则mid，判断在左或者右边，出来后回溯更新父节点信息*/
class Node{
	int l,r,sum,maxn;
	public Node(int l,int r)
	{
		this.l = l;
		this.r = r;
	}
}
public class SegmentTree {
	static int a[];
	static Node[] node;
	static int Sum;
	static int Max;

	static int max(int a,int b)
	{
		return a>b?a:b;
	}
	public static int searchSum(int score[],int n,int left,int right) {
		// TODO Auto-generated method stub
		a = score;
		node = new Node[n<<2];//初始化对象数组，存线段树的所有结点
		makeSegmentTree(0,1,n);//初始化线段树
		//查询区间和
		Sum= 0;
		querySum(left,right,0);
		return Sum;
	}

	static void querySum(int l,int r,int idx)
	{
		if(l<=node[idx].l&&node[idx].r<=r)
		{
			Sum += node[idx].sum;
		}
		else
		{
			int mid = (node[idx].l+node[idx].r)>>1;
			if(r <= mid )
				querySum(l,r,(idx<<1)|1);
			else if(l > mid)
				querySum(l,r,(idx<<1)+2);
			else
			{
				querySum(l,r,(idx<<1)|1);
				querySum(l,r,(idx<<1)+2);
			}
		}
	}
	static void makeSegmentTree(int index, int l, int r) 
	{
		node[index] = new Node(l,r); 
		if(l==r)
		{
			node[index].sum = a[l];
			node[index].maxn = a[l];
		}
		else
		{
			int mid = (node[index].l+node[index].r)>>1;
			makeSegmentTree((index<<1) | 1, l, mid);//构建左子树
			makeSegmentTree((index<<1) + 2, mid+1, r);//构建右子数
			node[index].sum = node[(index<<1) | 1].sum+node[(index<<1) + 2].sum;
			node[index].maxn = max(node[(index<<1) | 1].maxn,node[(index<<1)+2].maxn);
		}
	}

}


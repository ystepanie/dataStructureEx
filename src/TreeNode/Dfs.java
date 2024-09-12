package TreeNode;

public class Dfs {
	public Dfs() {
	}

	// 재귀를 사용한 이진 탐색 트리 값 찾기
	public TreeNode FindValue(TreeNode current, int target) {
		if (current == null)
			return null;
		if (target == current.value)
			return current;

		if (target < current.value && current.left != null) {
			return FindValue(current.left, target);
		}
		if (target > current.value && current.right != null) {
			return FindValue(current.right, target);
		}

		return null;
	}

	// 반복을 사용한 이진 탐색 트리 찾기
	public TreeNode FindValueItr(TreeNode current, int target) {
		TreeNode root = current;
		// root가 null이거나 목표를 찾았으면 반복 종료
		while (root != null && root.value != target) {
			if (target < current.value) {
				root = current.left;
			} else {
				root = current.right;
			}
		}

		return root;
	}

	// 루트 트리에서 검색
	public TreeNode FindTreeNode(BinarySearchTree tree, int target) {
		if (tree.root == null) {
			return null;
		}
		return FindValue(tree.root, target);
	}

	// 최상위 값 넣기
	public void InsertTreeNode(BinarySearchTree tree, int value) {
		if (tree.root == null) {
			tree.root = new TreeNode(value, null, null, null);
		} else {
			InsertNode(tree.root, value);
		}
	}

	// 값 넣기(중복 비허용)
	public void InsertNode(TreeNode current, int value) {
		if (value == current.value) {
			return;
		}

		if (value < current.value) {
			if (current.left != null) {
				InsertNode(current.left, value);
			} else {
				current.left = new TreeNode(value, null, null, current);
			}
		} else {
			if (current.right != null) {
				InsertNode(current.right, value);
			} else {
				current.right = new TreeNode(value, null, null, current);
			}
		}

	}

	// 값 삭제하기
	public void RemoveTreeNode(BinarySearchTree tree, TreeNode node) {
		if (tree.root == null || node == null)
			return;

		// 리프노드 제거
		if (node.left == null && node.right == null) {
			if (node.parent == null) {
				tree.root = null;
			} else if (node.parent.left == node) {
				node.parent.left = null;
			} else {
				node.parent.right = null;
			}
			return;
		}

		// 자식이 하나인 노드 제거
		if (node.left == null || node.right == null) {
			TreeNode child = node.left;
			if (node.left == null) {
				child = node.right;
			}

			child.parent = node.parent;
			// 부모노드가 없으면 남은 자식노드가 최상위가 된다.
			if (node.parent == null) {
				tree.root = child;
			} else if (node.parent.left == node) {
				node.parent.left = child;
			} else {
				node.parent.right = child;
			}
			return;
		}

		// 자식이 두개인 노드 제거
		if (node.left != null && node.right != null) {
			//후보자 찾기
			TreeNode successor = node.right;
			while (successor.left != null) {
				successor = successor.left;
			}
			RemoveTreeNode(tree, successor);

			//후보자를 삭제한 노드와 교체
			if (node.parent == null) {
				tree.root = successor;
			} else if (node.parent.left == node) {
				node.parent.left = successor;
			} else {
				node.parent.right = successor;
			}

			// 후보자와 후보자 자식간의 노드 연결
			successor.left = node.left;
			node.left.parent = successor;

			successor.right = node.right;
			// 후보자가 리프노드일 경우 순서가 바뀌면 오른쪽은 없는 경우가 있을 수 있다.
			if (node.right != null) {
				node.right.parent = successor;
			}
		}
	}
}

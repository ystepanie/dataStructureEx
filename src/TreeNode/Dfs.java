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
	// public TreeNode FindTreeNode(BinarySearchTree tree, int target) {
	//
	// }
}

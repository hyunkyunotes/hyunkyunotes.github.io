---
title: Math Refresher
categories: [ML]
tags: [CS224N]
datacamp: 1
maths: 1
toc: 1
date: 2025-04-29
---

{% include toc.html %}

## Linear Algebra

- $A\_i:$ row vectors of $A$ at row $i$.
- $A^k$: column vectors of $A$ at column $k$
- $ab\_{ij} = A\_i B^j$
- Orthogonality $\implies$ $A^TA=AA^T=I$
- Finding determinant $(-1)^{r+c+1}$
- $A\mathbf{x}=\lambda \mathbf{x}$, finding values and corresponding vectors

### SVD
- Reducing dimension of matrix $A_{mn}=U_{mm}S_{mn}V^T_{nn}$
- $U, V$ orthogonal matrices
- Columns of $V$ are orthonormal eigenvectors of $A^TA$ in decreasing order (i.e. eigenvector of biggest eigenvalue at $(0,0)$)
- Cols of $U$ are orthonormal eigenvectors of $AA^T$
- $S$ is a diagonal matrix of roots of eigenvalues of $U$ or $V$ in decreasing order

### Examples


$A=\begin{bmatrix}3 & 1 & 1 \\\\ -1 & 3 & 1 \end{bmatrix}$
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

## Vectors, Differentials, Tensors

### Differential Theory

- Differentiable implies $ f(x+h)=f(x) + d_xf(h)+o_{h\to0}(h)$ where $d_xf(h)$ is a linear function and $o_{h\to0}(h)$ is the Landau notation for the existence of $\epsilon(h)$ such that $\lim_{h\to0}\epsilon(h)=0$


#### Example

Let $f:\mathbb{R}^2\to \mathbb{R}$ such that $f(\begin{pmatrix}x_1\\\\ x_2\end{pmatrix})=3x_1+x_2^2$. Pick

$\begin{pmatrix}a\\\\ b\end{pmatrix}\in \mathbb{R}^2$ and $h=\begin{pmatrix}h_1 \\\\ h_2\end{pmatrix}\in \mathbb{R}^2$. We have

$f(\begin{pmatrix}a+h_1 \\\\ b+h_2\end{pmatrix})=3(a+h_1)+(b+h_2)^2$
$=f(a,b)+3h_1+2bh_2+o(h)$

Then, $\scriptstyle d_{\begin{pmatrix}a\\\\ b\end{pmatrix}}f(\begin{pmatrix}h_1\\\\ h_2\end{pmatrix}) =3h_1 + 2bh_2$

### Jacobian

- Assume $\mathbf{f}: \mathbb{R}^n\to \mathbb{R}^m$, then


$\displaystyle \frac{\partial \mathbf{f}}{\partial \mathbf{x}}\displaystyle = \displaystyle \begin{bmatrix}\frac{\partial f_1}{\partial x_1} & \dots & \frac{\partial f_1}{\partial x_n}\\\\ \dots & \dots & \dots \\\\ \frac{\partial f_m}{\partial x_1} & \dots & \frac{\partial f_m}{\partial x_n} \end{bmatrix}$

In other words, $(\frac{\partial\mathbf{f}}{\partial\mathbf{x}})\_{ij} = \frac{\partial f_i}{\partial x_j}$

- For example, assume $\mathbf{f}(x) = [f_1(x), f_2(x)] (f: \mathbb{R} \to \mathbb{R}^2)$ and $\mathbf{g}(\mathbf{y})=[g_1(y_1,y_2), g_2(y_1,y_2)]$. Then, by chain rule,


$\displaystyle \frac{\partial \mathbf{g}}{\partial x} = \begin{bmatrix}\frac{\partial g_1}{\partial f_1}\frac{\partial f_1}{\partial x} +\frac{\partial g_1}{\partial f_2}\frac{\partial f_2}{\partial x} \\\\ \frac{\partial g_2}{\partial f_1}\frac{\partial f_1}{\partial x} +\frac{\partial g_2}{\partial f_2}\frac{\partial f_2}{\partial x}\end{bmatrix}$

This equals the product of two jacobians

$ \displaystyle\frac{\partial \mathbf{g}}{\partial \mathbf{f}}\frac{\partial\mathbf{f}}{\partial x} = \begin{bmatrix}\frac{\partial g_1}{\partial f_1} & \frac{\partial g_1}{\partial f_2} \\\\ \frac{\partial g_2}{\partial f_1} & \frac{\partial g_2}{\partial f_2}\end{bmatrix}\begin{bmatrix}\frac{\partial f_1}{\partial x}\\\\\frac{\partial f_2}{\partial x}\end{bmatrix} $

#### Identities

(1) $\mathbf{z} =\mathbf{W}\mathbf{x}$, What is $\frac{\partial \mathbf{z}}{\partial \mathbf{x}}$?
- Suppose $ \mathbf{W} \in \mathbb{R}^{n\times m}$. Then, $\mathbf{z}$ is a function of $\mathbf{x}$ ($\mathbf{z}: \mathbb{R}^m \to \mathbb{R}^n$). So its jacobian will be $n \times m$. And,

$ z_i = \sum_{k=1}^m W_{ik}x_k $,

$ (\frac{\partial \mathbf{z}}{\partial \mathbf{x}})\_{ij}=\frac{\partial z_1}{\partial x_j}=\sum_{k=1}^m W_{ik}\frac{\partial}{\partial x_j}x_k = W_{ij} \implies \frac{\partial \mathbf{z}}{\partial \mathbf{x}} = \mathbf{W}$

(2) $\mathbf{z} =\mathbf{x}\mathbf{W},\quad\frac{\partial \mathbf{z}}{\partial \mathbf{x}}= \mathbf{W}^T$
(3) $\mathbf{z}=\mathbf{x},\quad \frac{\partial \mathbf{z}}{\partial \mathbf{x}}= I$
(4) elementwise function

$z=f(x) \implies z_i = f(x_i)\implies (\frac{\partial z}{\partial x})_{ij}=\frac{\partial}{\partial x_j}f(x_i)=\begin{cases}f'(x_i)\quad \text{ if } i=j \\\\ 0 \quad \text{ if otherwise} \end{cases} $
Then, $\frac{\partial z}{\partial x}= \text{diag}(f'(x))$
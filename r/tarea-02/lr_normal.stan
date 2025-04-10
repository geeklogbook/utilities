data {
  int<lower=0> N;         // Número de observaciones
  int<lower=0> K;         // Número de variables independientes
  matrix[N, K] X;         // Matriz de diseño
  vector[N] y;            // Variable dependiente
  real a0;                // Parámetro de la distribución Gamma para sigma
  real b0;                // Parámetro de la distribución Gamma para sigma
}
parameters {
  vector[K] beta;         // Coeficientes
  real<lower=0> sigma;    // Desviación estándar
}
model {
  beta ~ normal(0, 1);    // Prior normal para los coeficientes β
  sigma ~ inv_gamma(a0, b0); // Prior de sigma
  y ~ normal(X * beta, sigma); // Likelihood de los datos
}

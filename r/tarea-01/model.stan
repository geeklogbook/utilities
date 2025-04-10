// model.stan
data {
  int<lower=0> N; 
  vector[N] x;      
  real<lower=0> v0;    
  real<lower=0> a0;     
  real<lower=0> b0;    
}

parameters {
  real mu;              // µ
  real<lower=0> tau;    // τ
}

model {
  mu ~ normal(0, sqrt(v0));                    
  tau ~ gamma(a0, b0);                
  x ~ student_t(5, mu, 1 / sqrt(tau));        
}
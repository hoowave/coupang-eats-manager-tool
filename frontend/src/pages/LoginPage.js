import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';

function LoginPage() {
  const [form, setForm] = useState({ username: '', password: '' });
  const [isSubmitting, setIsSubmitting] = useState(false);
  const navigate = useNavigate();

  const handleChange = (e) => {
    const { name, value } = e.target;
    setForm((prev) => ({ ...prev, [name]: value }));
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    if (!form.username || !form.password) return;
    setIsSubmitting(true);
    // TODO: wire real login API
    setTimeout(() => {
      setIsSubmitting(false);
      navigate('/tools');
    }, 600);
  };

  return (
    <div className="login-page">
      <div className="login-card">
        <div className="brand">
          <img src={process.env.PUBLIC_URL + '/logo.svg'} alt="Coupang Eats" className="brand-logo" />
          <div className="brand-text" aria-label="Coupang Eats Manager Tool">Coupang Eats Manager Tool</div>
        </div>

        <form className="login-form" onSubmit={handleSubmit}>
          <div className="form-group">
            <label htmlFor="username" className="sr-only">아이디</label>
            <input
              id="username"
              name="username"
              type="text"
              inputMode="email"
              autoComplete="username"
              placeholder="아이디"
              value={form.username}
              onChange={handleChange}
              className="input"
            />
          </div>

          <div className="form-group">
            <label htmlFor="password" className="sr-only">비밀번호</label>
            <input
              id="password"
              name="password"
              type="password"
              autoComplete="current-password"
              placeholder="비밀번호"
              value={form.password}
              onChange={handleChange}
              className="input"
            />
          </div>

          <button type="submit" className="button" disabled={isSubmitting || !form.username || !form.password}>
            {isSubmitting ? '로그인 중...' : '로그인'}
          </button>
        </form>
      </div>
    </div>
  );
}

export default LoginPage;

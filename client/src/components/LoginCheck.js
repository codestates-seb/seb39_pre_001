import { useNavigate } from 'react-router-dom';

export default function LoginCheck({ e, token }) {
  e.preventDefault();
  const navigate = useNavigate();
  if (token) {
    return;
  } else {
    e.preventDefault();
    alert('로그인을 먼저 해주세요.');
    navigate('/users/login');
  }
}

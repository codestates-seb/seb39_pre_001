import { Link } from 'react-router-dom';
import styled from 'styled-components';

const StyledFooter = styled.footer`
  background-color: #232629;
  color: #9199a1;

  > .footer-container {
    box-sizing: border-box;
    max-width: 1264px;
    width: 100%;
    margin: 0 auto;
    padding: 32px 12px 12px 12px;
    display: flex;
    /* flex-flow는 flex-direction과 flex-wrap의 단축 속성 */
    flex-flow: row wrap;

    a {
      text-decoration: none;
      color: #9199a1;
      cursor: pointer;
    }

    li,
    ul {
      list-style: none;
      margin: 0;
      padding: 0;
    }

    > .footer-logo {
      flex: 0 0 64px;
      margin: -12px 0 32px 0;
    }

    > .footer-nav {
      display: flex;
      flex: 2 1 auto;
      flex-wrap: wrap;
      > .footer-column {
        padding: 0 12px 24px 0;
        flex: 1 0 auto;
        > h5 {
          margin-top: 0;
          margin-bottom: 12px;
          font-size: 13px;
          color: #babfc4;
          > a {
            color: inherit;
          }
        }
        > ul {
          font-size: 13px;
          > li {
            margin: 0;
            padding: 4px 0;
          }
        }
      }
    }

    > .footer-copyright {
      display: flex;
      flex: 1 1 150px;
      flex-direction: column;
      box-sizing: border-box;
      font-size: 11px;
      > ul {
        display: flex;
        > li {
          padding: 4px 0;
          margin-left: 12px;
          font-size: 11px;
          line-height: calc(17 / 13);
          :first-child {
            margin-left: 0;
          }
        }
      }
      > p {
        margin-top: auto;
        margin-bottom: 24px;
        line-height: 1.4;
      }
    }
  }
`;

const Footer = () => {
  return (
    <StyledFooter>
      <div className='footer-container'>
        <div className='footer-logo'>
          <Link to='/'>
            {/* svg 사용법!! */}
            <svg aria-hidden='true' width='32' height='37' viewBox='0 0 32 37'>
              <path d='M26 33v-9h4v13H0V24h4v9h22Z' fill='#BCBBBB'></path>
              <path
                d='m21.5 0-2.7 2 9.9 13.3 2.7-2L21.5 0ZM26 18.4 13.3 7.8l2.1-2.5 12.7 10.6-2.1 2.5ZM9.1 15.2l15 7 1.4-3-15-7-1.4 3Zm14 10.79.68-2.95-16.1-3.35L7 23l16.1 2.99ZM23 30H7v-3h16v3Z'
                fill='#F48024'></path>
            </svg>
          </Link>
        </div>
        <nav className='footer-nav'>
          <div className='footer-column'>
            <h5>
              <Link to='/'>STACK OVERFLOW</Link>
            </h5>
            <ul>
              <li>
                <Link to='/questions'>Questions</Link>
              </li>
              <li>Help</li>
            </ul>
          </div>
          <div className='footer-column'>
            <h5>PRODUCTS</h5>
            <ul>
              <li>Teams</li>
              <li>Advertising</li>
              <li>Collectives</li>
              <li>Talent</li>
            </ul>
          </div>
          <div className='footer-column'>
            <h5>COMPANY</h5>
            <ul>
              <li>About</li>
              <li>Press</li>
              <li>Work Here</li>
              <li>Legal</li>
              <li>Privacy Policy</li>
              <li>Terms of Service</li>
              <li>Contact Us</li>
              <li>Cookie Settings</li>
              <li>Cookie Policy</li>
            </ul>
          </div>
          <div className='footer-column'>
            <h5>STACK EXCHANGE NETWORK</h5>
            <ul>
              <li>Technology</li>
              <li>Culture & recreation</li>
              <li>Life & arts</li>
              <li>Science</li>
              <li>Professional</li>
              <li>Business</li>
              <li>API</li>
              <li>Data</li>
            </ul>
          </div>
        </nav>
        <div className='footer-copyright'>
          <ul>
            <li>Blog</li>
            <li>Facebook</li>
            <li>Twitter</li>
            <li>LinkedIn</li>
            <li>Instagram</li>
          </ul>
          <p>
            Site design / logo © 2022 Stack Exchange Inc; user contributions licensed under CC BY-SA.{' '}
            <span>rev 2022.8.31.42952</span>
          </p>
        </div>
      </div>
    </StyledFooter>
  );
};

export default Footer;

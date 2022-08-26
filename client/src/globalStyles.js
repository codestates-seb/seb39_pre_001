import styled, {createGlobalstyle} from 'styled-components';
import {reverseBackgroundColor, backgroundColor} from './data/GlobalData';


const GlobalStyle = createGlobalstyle`
* {
    box-sizing: border-box;
    margin: 0;
    padding: 0;
}
`

export const Container = styled.div`
width: 100%;
max-width: 1330px;
margin: 0 auto;
padding: 0 50px;

@media screen and (max-width: 960px) {
    padding: 0 30px
}
`

export const Section = styled.div`
color: white;
padding: 160px;
background: ${({inverse})=> (inverse? backgroundColor : reverseBackgroundColor)};
`

export const MainHeading = styled.h1`
font-size: clamp(2.3rem, 6vw, 4.5rem);
margin-bottom: 2rem;
color: ${({inverse})=> (inverse? reverseBackgroundColor : backgroundColor)};
width: 100%;
letter-spacing: 4px;
text-align: center;
`

export const Button = styled.button`
border-radius: 4px;
background: none;
white-space: space nowrap;
padding: ${({big})=>big? '12px 64px' : '10px 20px'};
font-weight: 600;
color: white;
font-size: ${({fontBig})=>fontBig? '20px' : '16px'};
`
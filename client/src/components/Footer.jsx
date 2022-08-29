import React from "react";
import styled from "styled-components";
import logo from "../assets/logo.png";
import Button from "./Button";

export default function Footer() {
  const products = [
    "Teams",
    "Advertising",
    "Collectives",
    "Talent",
  ];
  const company = [
    "About",
    "Press",
    "Work Here",
    "Legal",
    "Privacy Policy",
    "Teams of Service"
  ];
  return (
    <Container>
      <div className="upper-footer">
        <div className="col">
          <div className="brand">
          <div className="brand">
        StackOverfow
      </div>
            
          </div>
          <ul>
            <li>
              <span> +0213 456 987 </span>
            </li>
            <li>
              <span>test@gmail.com</span>
            </li>
            <li>
              <span>www.youtube.com</span>
            </li>
          </ul>
        </div>
        <div className="col">
          <h2>PRODUCTS</h2>
          <ul>
            {products.map((link) => (
              <li key={link}>{link}</li>
            ))}
          </ul>
        </div>
        <div className="col">
          <h2>COMPANY</h2>
          <ul>
            {company.map((link) => (
              <li key={link}>{link}</li>
            ))}
          </ul>
        </div>
        <div className="col">
          <h2>STACK EXCHANGE NETWORK</h2>
          <div className="newsletter">
            <input type="text" placeholder="Your Email" />
            <Button text="Subscribe Now" />
          </div>
        </div>
      </div>
    </Container>
  );
}

const Container = styled.footer`
  .upper-footer {
    display: grid;
    grid-template-columns: 1fr 1fr 1fr 1fr;
    justify-content: center;
    border-bottom: 2px solid var(--primary-color);
    padding-bottom: 2rem;
    gap: 5rem;
    .col {
      display: flex;
      flex-direction: column;
      gap: 2rem;
      color: var(--secondary-text);
      h2 {
        color: black;
      }
      ul {
        list-style: none;
        display: flex;
        flex-direction: column;
        gap: 1rem;
        li {
          cursor: pointer;
          transition: var(--default-transition);
          &:hover {
            color: var(--primary-color);
          }
        }
      }
      .newsletter {
        display: flex;
        flex-direction: column;
        gap: 1rem;
        input {
          padding: 1rem 2rem;
          border: none;
          font-size: 1.1rem;
          color: white;
          cursor: pointer;
          background-color: #f8f8f8;
        }
      }
    }
  }
  .lower-footer {
    padding: 2rem 0;
    text-align: center;
    a {
      text-decoration: none;
      color: var(--primary-color);
    }
  }
  @media screen and (min-width: 280px) and (max-width: 1080px) {
    margin: 2rem;
    .upper-footer {
      grid-template-columns: 1fr;
    }
  }
`;

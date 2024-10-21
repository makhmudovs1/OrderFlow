import React from 'react';
import './main.css';
import arrow from '../../assets/arrow.svg';

const Main = () => {
  const list = [
    {
      id: '1',
      title: 'Real-time tracking',
      text: 'App should have a real time tracking feature much like its competitors with the customer\n' +
        'knowing the location of his products in real time.',
    },
    {
      id: '2',
      title: 'Distance and cost calculation',
      text: 'Before placing an order, customer should be able to know how much his delivery would\n' +
        'cost and the rider to know how much and the distance.',
    },
    {
      id: '3',
      title: 'Payment options Card & Cash',
      text: 'Payment should involve card service and cash at delivery point and it should be\n' +
        'indicated which of the options the customer plans to use.',
    }
  ];
  return (
    <div className="main" id="main">
      <div className="container">
        <h2 className="main__title">Product Qualities</h2>
        <nav className="nav">
          <ul className="nav__menu">
            {list.map((item) => (
              <li className="nav__li" key={item.id}>
                <div className="d-flex">
                  <div><img src={arrow} alt="Arrow image"/></div>
                  <div className="nav__item">
                    <h3 className="nav__title">
                      {item.title}
                    </h3>
                    <p className="nav__text">
                      {item.text}
                    </p>
                  </div>
                </div>
              </li>
            ))}
          </ul>
        </nav>

        <div className="discovery">
          <div className="statement">
            <div className="stage d-flex align-items-center">
              <div className="stage__rectangle"></div>
              <h3 className="stage__text">
                Problem Statement
              </h3>
              <div className="stage__discovery">
                Discovery
              </div>
            </div>
            <div className="statement__text">
              About 75% of dispatch riders in Tajikistan are operating on an offline mode under different names.
              The company is out to give them an online presence for ease of booking while also making the logistics
              business more secured for the clients as all rider’s profile can be obtained from the app.
              Economically, the introduction of bicycle in our options will reduce the problem of unemployment as
              owners can make part-time income.
            </div>
          </div>
          <div className="product">
            <div className="statement">
              <div className="stage d-flex align-items-center">
                <div className="stage__rectangle"></div>
                <h3 className="stage__text">
                  About Our Product
                </h3>
                <div className="stage__discovery">
                  Discovery
                </div>
              </div>
              <div className="statement__text">
                OrderFlow is a dispatch-hailing platform (App) that offers real time package
                tracking. Using the services of motorcycle and bicycle owners for ease of delivery and cost
                effectiveness with the aim of becoming your one-stop logistics platform as you move
                across different states in the country.
              </div>
            </div>
          </div>
          <div className="process"></div>
        </div>
      </div>
    </div>
  );
};

export default Main;
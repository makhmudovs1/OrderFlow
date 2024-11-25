import './main.css';
import arrow from '../../assets/arrow.svg';
import Container from "../container/Container.jsx";
import Menu from "../menu/Menu.jsx";
import PageSection from "../pageSection/PageSection.jsx";

const Main = () => {
  const list = [
    {
      id: '1',
      title: 'Real-time tracking',
      text: 'App should have a real time tracking feature much like its competitors with the customer knowing the location of his products in real time.',
    },
    {
      id: '2',
      title: 'Distance and cost calculation',
      text: 'Before placing an order, customer should be able to know how much his delivery would cost and the rider to know how much and the distance.',
    },
    {
      id: '3',
      title: 'Payment options Card & Cash',
      text: 'Payment should involve card service and cash at delivery point and it should be indicated which of the options the customer plans to use.',
    },
  ];

  return (
    <div className="main" id="main">
      <Container>
        <h2 className="main__title">Product Qualities</h2>
        <Menu list={list} icon={arrow} />

        <div className="discovery">
          <PageSection
            title="Problem Statement"
            subtitle="Discovery"
          >
            About 75% of dispatch riders in Tajikistan are operating on an offline mode under different names.
            The company is out to give them an online presence for ease of booking while also making the logistics
            business more secured for the clients as all rider’s profile can be obtained from the app.
            Economically, the introduction of bicycle in our options will reduce the problem of unemployment as
            owners can make part-time income.
          </PageSection>

          <PageSection
            title="About Our Product"
            subtitle="Discovery"
          >
            OrderFlow is a dispatch-hailing platform (App) that offers real time package
            tracking. Using the services of motorcycle and bicycle owners for ease of delivery and cost
            effectiveness with the aim of becoming your one-stop logistics platform as you move
            across different states in the country.
          </PageSection>
        </div>
      </Container>
    </div>
  );
};

export default Main;

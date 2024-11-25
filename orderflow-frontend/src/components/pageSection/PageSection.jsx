import PropTypes from 'prop-types';

const PageSection = ({ title, subtitle, children }) => {
  return (
    <div className="statement">
      <div className="stage d-flex align-items-center">
        <div className="stage__rectangle"></div>
        <h3 className="stage__text">{title}</h3>
        <div className="stage__discovery">{subtitle}</div>
      </div>
      <div className="statement__text">{children}</div>
    </div>
  );
};

PageSection.propTypes = {
  title: PropTypes.string.isRequired,
  subtitle: PropTypes.string.isRequired,
  children: PropTypes.node.isRequired,
};

export default PageSection;

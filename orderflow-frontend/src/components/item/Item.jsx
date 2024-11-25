import PropTypes from 'prop-types';

const Item = ({ icon, title, text }) => {
  return (
    <div className="d-flex">
      <div><img src={icon} alt="Icon"/></div>
      <div className="nav__item">
        <h3 className="nav__title">{title}</h3>
        <p className="nav__text">{text}</p>
      </div>
    </div>
  );
};

Item.propTypes = {
  icon: PropTypes.string.isRequired,
  title: PropTypes.string.isRequired,
  text: PropTypes.string.isRequired,
};

export default Item;

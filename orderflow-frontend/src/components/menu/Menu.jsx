import PropTypes from 'prop-types';
import Item from "../item/Item.jsx";

const Menu = ({ list, icon }) => {
  return (
    <nav className="nav">
      <ul className="nav__menu">
        {list.map((item) => (
          <li className="nav__li" key={item.id}>
            <Item icon={icon} title={item.title} text={item.text} />
          </li>
        ))}
      </ul>
    </nav>
  );
};

Menu.propTypes = {
  list: PropTypes.arrayOf(
    PropTypes.shape({
      id: PropTypes.string.isRequired,
      title: PropTypes.string.isRequired,
      text: PropTypes.string.isRequired,
    })
  ).isRequired,
  icon: PropTypes.string.isRequired,
};

export default Menu;

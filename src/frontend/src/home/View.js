import React from "react";
import {
  Switch,
  Route
} from 'react-router-dom';

import AccountsList from '../pages/AccountsList';

export default function View({ client_id }) {
  return (
    <Switch>
      <Route path="/">
        <AccountsList client_id={client_id} />
      </Route>
    </Switch>
  );
}
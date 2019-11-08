package go.fynd.twitter.data

import go.fynd.twitter.data.local.db.DbHelper
import go.fynd.twitter.data.remote.ApiHelper

interface DataManager : DbHelper, ApiHelper
